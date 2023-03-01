package iut.math
import kotlin.random.Random

class SquareMatrix (order : Int) {
    private var order : Int
    private var mat : Array<Array<Int>>

    init {
        this.order=order
        if (order<1||order==null)throw IllegalArgumentException()
        mat = Array(order) { Array(order){0} }
    }

    fun order() : Int {
        return this.mat.size
    }

    fun isNull() : Boolean {
        for (i in 0 until this.mat.size){
            for (y in 0 until this.mat.size){
                if(this.mat[i][y]==1){
                    return false
                }
            }
        }
        return true
    }

    override fun toString(): String {
        var txt: String = ""
        for (i in 0 until this.mat.size){
            for (y in 0 until this.mat.size){
                txt+="${this.mat[i][y]}  "
            }
            txt+="\n"
        }
        return txt
    }
    
    fun setAsIdentity() {
        for (i in 0 until this.mat.size){
            for (y in 0 until this.mat.size){
                this.mat[i][y]=0
                if (y==i)this.mat[i][y]=1
            }
        }
    }

    fun isIdentity() : Boolean {
        for (i in 0 until this.mat.size){
            for (y in 0 until this.mat.size){
                if (i!=y){
                    if(this.mat[i][y]==1){
                        return false
                    }
                }
                if(this.mat[i][i]==0){
                    return false
                }

            }
        }
        return true
    }

    fun randomize(from : Int, until :Int) {
        if (until<from)throw IllegalArgumentException()
        for (i in 0 until this.mat.size){
            for (y in 0 until this.mat.size){
                this.mat[i][y]=Random.nextInt(from, until)
            }
        }
    }

    override fun equals(other: Any?) : Boolean {
        if (other is SquareMatrix) {
            if (other.mat.size!=this.mat.size)return false
            for (i in 0 until other.mat.size) {
                for (y in 0 until other.mat.size) {
                    if (other.mat[i][y] != this.mat[i][y]) {
                        return false
                    }
                }
            }
            return true
        }
        return false
    }

    operator fun plus(matrix : SquareMatrix) : SquareMatrix {
        if (this.mat.size!=matrix.mat.size)throw java.lang.ArithmeticException()
        for (i in 0 until matrix.mat.size){
            for (y in 0 until matrix.mat.size){
                matrix.mat[i][y]+=this.mat[i][y]
            }
        }
        return matrix
    }

    operator fun times(factor : Int) : SquareMatrix {
        var trans= SquareMatrix(this.order())
        println("1:\n$this \n2:\n $factor")
        for (i in 0 until this.mat.size){
            for (y in 0 until this.mat.size){
                trans.mat[i][y]=this.mat[i][y]*factor
            }
        }
        return trans
    }

    operator fun unaryMinus() : SquareMatrix {
        return this.times(-1)
    }

    operator fun minus(matrix : SquareMatrix) : SquareMatrix {
        return this+matrix.unaryMinus()
    }

    fun transposite() : SquareMatrix {
        var trans= SquareMatrix(this.order())
        for (i in 0 until this.mat.size){
            for (y in 0 until this.mat.size){
                trans.mat[i][y]=this.mat[y][i]
            }
        }
        return trans
    }


    fun isSymetrical() : Boolean {
        return this==this.transposite()
    }

    fun isAntiSymetrical() : Boolean {
        for (i in 0 until this.mat.size){
            for (y in 0 until this.mat.size){
                if (this.mat[i][y]!=-this.mat[y][i])return false
            }
        }
        return true
    }


    operator fun times(matrix : SquareMatrix) : SquareMatrix {
        if (this.mat.size!=matrix.mat.size)throw java.lang.ArithmeticException()
        var trans= SquareMatrix(this.order())
        for (i in 0 until this.mat.size){
            for (y in 0 until this.mat.size){
                for (z in 0 until this.mat.size){
                    trans.mat[i][y]+=this.mat[i][z]*matrix.mat[z][y]
                }
            }
        }
        return trans
    }


}