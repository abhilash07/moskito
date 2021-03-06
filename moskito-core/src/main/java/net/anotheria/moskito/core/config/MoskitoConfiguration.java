package net.anotheria.moskito.core.config;

import com.google.gson.annotations.SerializedName;
import net.anotheria.moskito.core.config.accumulators.AccumulatorsConfig;
import net.anotheria.moskito.core.config.dashboards.DashboardsConfig;
import net.anotheria.moskito.core.config.filter.FilterConfig;
import net.anotheria.moskito.core.config.gauges.GaugesConfig;
import net.anotheria.moskito.core.config.journey.JourneyConfig;
import net.anotheria.moskito.core.config.plugins.PluginsConfig;
import net.anotheria.moskito.core.config.producers.BuiltinProducersConfig;
import net.anotheria.moskito.core.config.producers.MBeanProducerConfig;
import net.anotheria.moskito.core.config.thresholds.ThresholdsAlertsConfig;
import net.anotheria.moskito.core.config.thresholds.ThresholdsConfig;
import net.anotheria.moskito.core.config.tracing.TracingConfiguration;
import org.configureme.annotations.Configure;
import org.configureme.annotations.ConfigureMe;

import java.io.Serializable;

/**
 * This class contains complete moskito configuration at runtime. It is configured with ConfigureMe, but can be altered
 * programmatically. Use MoskitoConfigurationHolder.getConfiguration/setConfiguration to access/alter this class.
 *
 * @author lrosenberg
 * @since 22.10.12 15:59
 */
@ConfigureMe(name="moskito")
public class MoskitoConfiguration implements Serializable{
	/**
	 * SerialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Config object for alerting.
	 */
	@Configure
	@SerializedName("@thresholdsAlertsConfig")
	private ThresholdsAlertsConfig thresholdsAlertsConfig = new ThresholdsAlertsConfig();

	/**
	 * Config object for thresholds.
	 */
	@Configure
	@SerializedName("@thresholdsConfig")
	private ThresholdsConfig thresholdsConfig = new ThresholdsConfig();

	/**
	 * Config object for gauges.
	 */
	@Configure
	@SerializedName("@gaugesConfig")
	private GaugesConfig gaugesConfig = new GaugesConfig();

	/**
	 * Config object for dashboards.
	 */
	@Configure
	@SerializedName("@dashboardsConfig")
	private DashboardsConfig dashboardsConfig = new DashboardsConfig();

	/**
	 * Config object for accumulators.
	 */
	@Configure
	@SerializedName("@accumulatorsConfig")
	private AccumulatorsConfig accumulatorsConfig = new AccumulatorsConfig();

	/**
	 * Config objects for plugins.
	 */
	@Configure
	@SerializedName("@pluginsConfig")
	private PluginsConfig pluginsConfig = new PluginsConfig();

    /**
     * Config object for generic MBean producers.
     */
    @Configure
    @SerializedName("@mbeanProducersConfig")
    private MBeanProducerConfig mbeanProducersConfig = new MBeanProducerConfig();

	/**
	 * Configuration for builtin producers. Allows to switch off builtin producers.
	 */
	@Configure
	@SerializedName("@builtinProducersConfig")
	private BuiltinProducersConfig builtinProducersConfig = new BuiltinProducersConfig();

	/**
	 * Configuration for tracing.
	 */
	@Configure
	@SerializedName("@tracingConfig")
	private TracingConfiguration tracingConfig = new TracingConfiguration();

	@Configure
	@SerializedName("@journeyConfig")
	private JourneyConfig journeyConfig = new JourneyConfig();

	@Configure
	@SerializedName("@filterConfig")
	private FilterConfig filterConfig = new FilterConfig();

	public ThresholdsAlertsConfig getThresholdsAlertsConfig() {
		return thresholdsAlertsConfig;
	}

	public void setThresholdsAlertsConfig(ThresholdsAlertsConfig thresholdsAlertsConfig) {
		this.thresholdsAlertsConfig = thresholdsAlertsConfig;
	}

	public ThresholdsConfig getThresholdsConfig() {
		return thresholdsConfig;
	}

	public void setThresholdsConfig(ThresholdsConfig thresholds) {
		this.thresholdsConfig = thresholds;
	}

	@Override public String toString(){
		return "thresholdsAlertsConfig: "+thresholdsAlertsConfig+", thresholds: "+thresholdsConfig+", accumulators:" +accumulatorsConfig+", gauges: "+gaugesConfig+", dashboards: "+dashboardsConfig;
	}

	public AccumulatorsConfig getAccumulatorsConfig() {
		return accumulatorsConfig;
	}

	public void setAccumulatorsConfig(AccumulatorsConfig accumulatorsConfig) {
		this.accumulatorsConfig = accumulatorsConfig;
	}

	public PluginsConfig getPluginsConfig() {
		return pluginsConfig;
	}

	public void setPluginsConfig(PluginsConfig pluginsConfig) {
		this.pluginsConfig = pluginsConfig;
	}

    /**
     * @return {@link #mbeanProducersConfig}
     */
    public MBeanProducerConfig getMbeanProducersConfig() {
        return mbeanProducersConfig;
    }

    /**
     * @param mbeanProducersConfig
     *            new {@link MBeanProducerConfig} setup.
     */
    public void setMbeanProducersConfig(MBeanProducerConfig mbeanProducersConfig) {
        this.mbeanProducersConfig = mbeanProducersConfig;
    }

	public BuiltinProducersConfig getBuiltinProducersConfig() {
		return builtinProducersConfig;
	}

	public void setBuiltinProducersConfig(BuiltinProducersConfig builtinProducersConfig) {
		this.builtinProducersConfig = builtinProducersConfig;
	}

	public GaugesConfig getGaugesConfig() {
		return gaugesConfig;
	}

	public void setGaugesConfig(GaugesConfig gaugesConfig) {
		this.gaugesConfig = gaugesConfig;
	}

	public DashboardsConfig getDashboardsConfig() {
		return dashboardsConfig;
	}

	public void setDashboardsConfig(DashboardsConfig dashboardsConfig) {
		this.dashboardsConfig = dashboardsConfig;
	}

	public TracingConfiguration getTracingConfig() {
		return tracingConfig;
	}

	public void setTracingConfig(TracingConfiguration tracingConfig) {
		this.tracingConfig = tracingConfig;
	}

	public JourneyConfig getJourneyConfig() {
		return journeyConfig;
	}

	public void setJourneyConfig(JourneyConfig journeyConfig) {
		this.journeyConfig = journeyConfig;
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
}


