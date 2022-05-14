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
        if (text.getString().startsWith("  Ответь на вопрос:")) {
            if (((ConfigBoolean) AutoCMConfig.OPTIONS.get(0)).getBooleanValue()) {
                if (text.getString().contains("Как называется губка из Губки Боба?")) {
                    MinecraftClient.getInstance().player.sendChatMessage("Боб");
                } else if (text.getString().contains("Кто создатель сервера?")) {
                    MinecraftClient.getInstance().player.sendChatMessage("Santa");
                } else if (text.getString().contains("Кто президент России?")) {
                    MinecraftClient.getInstance().player.sendChatMessage("Путин");
                } else if (text.getString().contains("Назовите столицу России")) {
                    MinecraftClient.getInstance().player.sendChatMessage("Москва");
                } else if (text.getString().contains("Назовите столицу Украiны")) {
                    MinecraftClient.getInstance().player.sendChatMessage("Киев");
                } else if (text.getString().contains("Назовите год выхода MINECRAFT")) {
                    MinecraftClient.getInstance().player.sendChatMessage("2011");
                } else if (text.getString().contains("В каком году был основан CheatMine")) {
                    MinecraftClient.getInstance().player.sendChatMessage("2016");
                } else if (text.getString().contains("Назовите фамилию Пушкина")) {
                    MinecraftClient.getInstance().player.sendChatMessage("Пушкин");
                } else if (text.getString().contains("Кто создал таблицу Менделеева")) {
                    MinecraftClient.getInstance().player.sendChatMessage("Менделеев");
                } else if (text.getString().contains("Как называется корабль из Титаника?")) {
                    MinecraftClient.getInstance().player.sendChatMessage("Титаник");
                } else if (text.getString().contains("Как называется остров в мультфильме Мадагаскар?")) {
                    MinecraftClient.getInstance().player.sendChatMessage("Мадагаскар");
                }
            }
        }

        else if (text.getString().startsWith("  Решите пример:")) {
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

                            MinecraftClient.getInstance().player.sendChatMessage("" + result);
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

                            MinecraftClient.getInstance().player.sendChatMessage("" + result);
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

                            MinecraftClient.getInstance().player.sendChatMessage("" + result);
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

                            MinecraftClient.getInstance().player.sendChatMessage("" + result);
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }

                    })).start();
                }

            }
        }
    }
}
