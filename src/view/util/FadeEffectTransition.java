package view.util;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.util.Duration;
/**
 * Classe responsável pelo efeito de transição entre as telas de interface gráfica do sistema.
 * @author Patrick Fernandes Rios
 * @since 03/07/2018
 * */
public class FadeEffectTransition
{
    public FadeEffectTransition(Parent parent)
    {
        FadeTransition fade = new FadeTransition(Duration.millis(500), parent);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }
}
