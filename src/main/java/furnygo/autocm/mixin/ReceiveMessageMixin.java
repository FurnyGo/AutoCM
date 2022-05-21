package furnygo.autocm.mixin;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigString;
import furnygo.autocm.AutoCMConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public class ReceiveMessageMixin {
    @Inject(method = "addMessage(Lnet/minecraft/text/Text;I)V", at = @At("HEAD"))
    public void addMessage(Text text, int messageId, CallbackInfo info) {
        int delay = Integer.parseInt(((ConfigString) AutoCMConfig.OPTIONS.get(2)).getStringValue());
        String prefix = ((ConfigString) AutoCMConfig.OPTIONS.get(3)).getStringValue();
        String suffix = ((ConfigString) AutoCMConfig.OPTIONS.get(4)).getStringValue();

        if (text.getString().startsWith("  Ответь на вопрос:")) {
            if (((ConfigBoolean) AutoCMConfig.OPTIONS.get(0)).getBooleanValue()) {
                if (text.getString().contains("Как называется губка из Губки Боба?")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"Боб"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("Кто создатель сервера?")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"Santa"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("Кто президент России?")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"Путин"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("Назовите столицу России")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"Москва"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("Назовите столицу Украiны")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"Киев"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("Назовите год выхода MINECRAFT")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"2011"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("В каком году был основан CheatMine")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"2016"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("Назовите фамилию Пушкина")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"Пушкин"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("Кто создал таблицу Менделеева")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"Менделеев"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("Как называется корабль из Титаника?")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"Титаник"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                } else if (text.getString().contains("Как называется остров в мультфильме Мадагаскар?")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            MinecraftClient.getInstance().player.sendChatMessage(prefix+"Мадагаскар"+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    })).start();
                }
            }
        } else if (text.getString().startsWith("  Решите пример:")) {
            String msg = text.getString();
            if (((ConfigBoolean) AutoCMConfig.OPTIONS.get(1)).getBooleanValue()) {
                // plus
                if (text.getString().contains(" + ")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            int firstNumStart = msg.indexOf("пример: ") + 8;
                            int firstNumEnd = msg.indexOf(" +");
                            var firstNumString = msg.substring(firstNumStart, firstNumEnd);
                            int firstNum = Integer.parseInt(firstNumString);

                            int secondNumStart = msg.indexOf("+ ") + 2;
                            int secondNumEnd = msg.indexOf(" =");
                            var secondNumString = msg.substring(secondNumStart, secondNumEnd);
                            int secondNum = Integer.parseInt(secondNumString);

                            int result = firstNum + secondNum;

                            MinecraftClient.getInstance().player.sendChatMessage(prefix+result+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }

                    })).start();
                }

                // minus
                if (text.getString().contains(" - ")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            int firstNumStart = msg.indexOf("пример: ") + 8;
                            int firstNumEnd = msg.indexOf(" -");
                            var firstNumString = msg.substring(firstNumStart, firstNumEnd);
                            int firstNum = Integer.parseInt(firstNumString);

                            int secondNumStart = msg.indexOf("- ") + 2;
                            int secondNumEnd = msg.indexOf(" =");
                            var secondNumString = msg.substring(secondNumStart, secondNumEnd);
                            int secondNum = Integer.parseInt(secondNumString);

                            int result = firstNum - secondNum;

                            MinecraftClient.getInstance().player.sendChatMessage(prefix+result+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }

                    })).start();
                }

                // umnozhit
                if (text.getString().contains(" * ")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            int firstNumStart = msg.indexOf("пример: ") + 8;
                            int firstNumEnd = msg.indexOf(" *");
                            var firstNumString = msg.substring(firstNumStart, firstNumEnd);
                            int firstNum = Integer.parseInt(firstNumString);

                            int secondNumStart = msg.indexOf("* ") + 2;
                            int secondNumEnd = msg.indexOf(" =");
                            var secondNumString = msg.substring(secondNumStart, secondNumEnd);
                            int secondNum = Integer.parseInt(secondNumString);

                            int result = firstNum * secondNum;

                            MinecraftClient.getInstance().player.sendChatMessage(prefix+result+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }

                    })).start();
                }

                // razdelit
                if (text.getString().contains(" / ")) {
                    (new Thread(() -> {
                        try {
                            Thread.sleep(delay);
                            int firstNumStart = msg.indexOf("пример: ") + 8;
                            int firstNumEnd = msg.indexOf(" /");
                            var firstNumString = msg.substring(firstNumStart, firstNumEnd);
                            int firstNum = Integer.parseInt(firstNumString);

                            int secondNumStart = msg.indexOf("/ ") + 2;
                            int secondNumEnd = msg.indexOf(" =");
                            var secondNumString = msg.substring(secondNumStart, secondNumEnd);
                            int secondNum = Integer.parseInt(secondNumString);

                            int result = firstNum / secondNum;

                            MinecraftClient.getInstance().player.sendChatMessage(prefix+result+suffix);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }

                    })).start();
                }

            }
        }
    }
}
