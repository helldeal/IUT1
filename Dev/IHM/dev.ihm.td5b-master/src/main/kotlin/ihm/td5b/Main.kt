package ihm.td5b


import ihm.td5b.controleur.*
import ihm.td5b.vue.TitledPaneLivre
import ihm.td5b.vue.TitledPaneLivreModification
import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.Scene

class Main: Application() {

    override fun start(primaryStage: Stage) {

        val vue=MainVue()
        val modele=Bibliotheque()

        modele.preremplir()
        vue.updateLivres(modele.livres,modele.courant)
        vue.panneauDroit.update(modele.courant,modele.donneLivre())

        vue.updateLivres(modele.livres,ControleurDetailLivre(vue, modele),modele.courant)
        vue.updatePanneauDroit(vue.panneauDroit)
        vue.activerBouton1(true)
        vue.activerBouton2(true)

        vue.fixeListenerBouton(vue.panneauDroit.bouton1,ControleurLivrePrecedent(vue, modele))
        vue.fixeListenerBouton(vue.panneauDroit.bouton2,ControleurLivreSuivant(vue, modele))

        vue.fixeListenerBouton(vue.boutonModification,ControleurModification(vue, modele))
        vue.fixeListenerBouton(vue.boutonAjout,ControleurAjout(vue, modele))
        vue.fixeListenerBouton(vue.boutonSuppression,ControleurSuppression(vue, modele))



        val scene = Scene(vue, 550.0, 350.0)
        primaryStage.title="TD5B MVC"
        primaryStage.scene=scene
        primaryStage.show()


    }
}

fun main(){
    Application.launch(Main::class.java)
}