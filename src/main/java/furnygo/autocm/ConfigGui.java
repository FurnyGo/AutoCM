package furnygo.autocm;

import fi.dy.masa.malilib.gui.GuiConfigsBase;
import org.apache.logging.log4j.LogManager;

import java.util.List;

public class ConfigGui extends GuiConfigsBase {
    public ConfigGui() {
        super(10, 50, "autocm", null, "Конфигурация AutoCM");
    }

    @Override
    public List<ConfigOptionWrapper> getConfigs() {
        return ConfigOptionWrapper.createFor(AutoCMConfig.OPTIONS);
    }

    @Override
    protected void onSettingsChanged() {
        super.onSettingsChanged();
        AutoCMConfig.saveToFile();
        AutoCMConfig.loadFromFile();
        LogManager.getLogger().info("Настройки сохранены.");
    }
}
