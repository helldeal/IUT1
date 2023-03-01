package ihm.td1.figures

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class Groupe(couleur: Color): FormeGeo(couleur) {
   private var formes: MutableList<FormeGeo>

    init {
        this.formes = ArrayList<FormeGeo>()
    }

    fun taille(): Int {
        return this.formes.size
    }

    fun ajouter(forme: FormeGeo) {
        forme.colorer(this.couleur)
        this.formes.add(forme)
    }

    fun consulter(index: Int): FormeGeo {
        return this.formes.get(index)
    }

    override fun dessiner(g: GraphicsContext) {
        for (i in formes){
            i.dessiner(g)
        }
    }

}
