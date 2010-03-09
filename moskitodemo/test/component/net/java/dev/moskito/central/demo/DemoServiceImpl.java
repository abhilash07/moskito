package net.java.dev.moskito.central.demo;

import net.java.dev.moskito.central.StatStorage;
import net.java.dev.moskito.central.StatStorageException;
import net.java.dev.moskito.central.storages.SynchroneousConnector;
import net.java.dev.moskito.core.predefined.ServiceStats;
import net.java.dev.moskito.core.predefined.Constants;
import net.java.dev.moskito.core.stats.Interval;
import net.java.dev.moskito.core.stats.IIntervalListener;
import net.java.dev.moskito.core.producers.IStatsSnapshot;
import net.java.dev.moskito.core.producers.SnapshotArchiverRegistry;
import net.java.dev.moskito.core.producers.ISnapshotArchiver;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This demo class generates service stats and produces different results in the echo method impl
 * Duration of each echo method call is random between MIN_MILLIS_DURATION and MAX_MILLIS_DURATION constant values
 * Chance of failure is random and given in percents as FAILURE_CHANCE_PERCENTAGE constant
 *
 * @author imercuriev
 *         Date: Feb 26, 2010
 *         Time: 9:56:40 AM
 */
public class DemoServiceImpl implements IDemoService {

    private static final int MIN_MILLIS_DURATION = 10;
    private static final int MAX_MILLIS_DURATION = 100;
    private static final int FAILURE_CHANCE_PERCENTAGE = 10;

    private ServiceStats stats;

    public DemoServiceImpl(final StatStorage storage) {
        this.stats = new ServiceStats("demo", Constants.DEFAULT_INTERVALS);
        // get host name
        String host;
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException("Cannot create stats", e);
        }
        // then store it on intervals
        SnapshotArchiverRegistry.registerArchiverAllIntervals(new SynchroneousConnector(stats, storage,  host));
    }

    public <T extends Serializable> T echo(T aValue) throws DemoServiceException {
        long start = System.nanoTime();
        System.out.println("Echo method called w/ param: " + (aValue == null ? aValue : aValue.toString()));
        try {
            long duration = getDuration();
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {}
            if (isFailure()) {
                throw new DemoServiceException("The echo call failed");
            } else {
                Serializable result = "The echo call succeed";
                return (T) result;
            }
        } finally {
            long end = System.nanoTime();
            this.stats.addRequest();
            this.stats.addExecutionTime((end - start)/1000/1000);
        }
    }

    private boolean isFailure() {
        return FAILURE_CHANCE_PERCENTAGE > Math.random() * 100;
    }

    private long getDuration() {
        return MIN_MILLIS_DURATION + Math.round((MAX_MILLIS_DURATION - MIN_MILLIS_DURATION) * Math.random());
    }
}
