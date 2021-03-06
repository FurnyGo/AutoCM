package furnygo.autocm;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigString;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;

import java.io.File;

public class AutoCMConfig implements IConfigHandler {
    public static final ImmutableList<IConfigBase> OPTIONS = getConfig();

    private static ImmutableList<IConfigBase> getConfig() {
        return ImmutableList.of(
                new ConfigBoolean("Вопросы", Value.VOPROSI.getAsBoolean(), "Включение ответов на вопросы"),
                new ConfigBoolean("Примеры", Value.PRIMERI.getAsBoolean(), "Включение ответов на примеры"),
                new ConfigString("Задержка в миллисекундах", Value.DELAY.getAsString(), "Задержка между вопросом и ответом"),
                new ConfigString("Префикс", Value.PREFIX.getAsString(), "Префикс перед ответом"),
                new ConfigString("Суффикс", Value.SUFFIX.getAsString(), "Суффикс после ответом"),
                new ConfigBoolean("Лотерея", Value.LOTTERY.getAsBoolean(), "Авто ставка на лотерею")
        );
    }

    public static void loadFromFile() {
        File configFile = new File(FileUtils.getConfigDirectory(), "autocm.json");

        if (configFile.exists() && configFile.isFile() && configFile.canRead()) {
            JsonElement element = JsonUtils.parseJsonFile(configFile);

            if (element != null && element.isJsonObject()) {
                JsonObject root = element.getAsJsonObject();
                ConfigUtils.readConfigBase(root, "AutoCM", OPTIONS);
            }
        }
    }

    public static void saveToFile() {
        File dir = FileUtils.getConfigDirectory();

        if ((dir.exists() && dir.isDirectory()) || dir.mkdirs()) {
            JsonObject root = new JsonObject();
            ConfigUtils.writeConfigBase(root, "AutoCM", OPTIONS);
            JsonUtils.writeJsonToFile(root, new File(dir, "autocm.json"));
        }
    }

    @Override
    public void load() {
        loadFromFile();
    }

    @Override
    public void save() {
        saveToFile();
    }

    public enum Value {
        VOPROSI("true"),
        PRIMERI("true"),
        DELAY("0"),
        PREFIX("! "),
        SUFFIX(" [AutoCM]"),
        LOTTERY("false");


        private final String value;

        Value(String value) {
            this.value = value;
        }

        public String getAsString() {
            return value;
        }

        public boolean getAsBoolean() {
            return Boolean.parseBoolean(value);
        }
    }
}
