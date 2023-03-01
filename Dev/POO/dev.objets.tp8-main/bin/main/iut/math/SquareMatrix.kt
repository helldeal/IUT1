package iut.math
import kotlin.random.Random

class SquareMatrix (order : Int) {
    private var order : Int
    private var mat : Array<Array<Int>>

    init {
        this.order=order
        mat = Array(order) { Array(order){0} }
    }

    fun order() : Int {
        return mat.size
    }

    fun isNull() : Boolean {
        for (i in 0 until mat.size){
            for (y in 0 until mat.size){
                if(mat[i][y]==1){
                    return false
                }
            }
        }
        return true
    }

    override fun toString(): String {
        var txt: String = ""
        for (i in mat){
            txt+="$i\n"
        }
        return txt
    }
    
    fun setAsIdentity() {
        for (i in 0 until mat.size){
            for (y in 0 until mat.siimport kotlin.random.Randomze){
                mat[i][y]=1
            }
        }
    }

    fun isIdentity() : Boolean {
        for (i in 0 until mat.size){
            for (y in 0 until mat.size){
                if(mat[i][y]==0){
                    return false
                }
            }
        }
        return true
    }

    fun randomize(from : Int, until :Int) {
        for (i in 0 until mat.size){
            for (y in 0 until mat.size){
                mat[i][y]=Random.nextInt(from, until) 
            }
        }
    }
    /* 
    override fun equals(other: Any?) : Boolean {
        // TODO
        throw NotImplementedError()
    }

    operator fun plus(matrix : SquareMatrix) : SquareMatrix {
        // TODO
        throw NotImplementedError()
    }

    operator fun times(factor : Int) : SquareMatrix {
        // TODO
        throw NotImplementedError()
    }

    operator fun unaryMinus() : SquareMatrix {
        // TODO
        throw NotImplementedError()
    }

    operator fun minus(matrix : SquareMatrix) : SquareMatrix {
        // TODO
        throw NotImplementedError()
    }

    fun transposite() : SquareMatrix {
        // TODO
        throw NotImplementedError()
    }


    fun isSymetrical() : Boolean {
        return false
    }

    fun isAntiSymetrical() : Boolean {
        return false
    }


    operator fun times(matrix : SquareMatrix) : SquareMatrix {
        // TODO
        return SquareMatrix(1)
    }
    */

}