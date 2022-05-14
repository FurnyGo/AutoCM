package furnygo.autocm;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;

public class AutoCMMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // To prevent HeadlessExceptions when copying to clipboard.
        System.setProperty("java.awt.headless", "false");
        AutoCMConfig.loadFromFile();
        LogManager.getLogger().info("§aAutoCM activated!");
    }
}
