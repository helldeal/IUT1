package ihm.td4

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.util.Duration

/**
 * classe qui permet de gérer un compteur de temps
 *
 * @param periode: la periode liée au déclenchement d'un événement de type ACTION
 *
 * @param eventHandler: un ecouteur qui récupérera l'événement généré par le timer toutes les "periode"=> l'unité est la seconde
 *
 */
class Timer(periode: Double, eventHandler:EventHandler<ActionEvent>?) {


    private var timer: Timeline
    var keyFrame: KeyFrame
    private set

    init {
        this.timer=Timeline()
        this.timer.cycleCount=Timeline.INDEFINITE
        this.keyFrame=KeyFrame(Duration.seconds(periode), eventHandler)
        this.timer.keyFrames.add(keyFrame)

    }


    /**
     * méthode qui démarre le timer
      */
    fun start(){
        timer.play()
    }


    /*

    méthode qui stoppe le timer
    */
    fun stop(){
		timer.stop()
    }


}