import iut.math.SquareMatrix
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestMatrix {

    @Test
    fun `matrice 0  # exception`() {
        assertThrows<IllegalArgumentException> {
            SquareMatrix(0)
        }
    }

    @Test
    fun `matrice -10  # exception`() {
        assertThrows<IllegalArgumentException> {
            SquareMatrix(-10)
        }
    }

    @Test
    fun `matrice ok 1`() {
        assertDoesNotThrow { SquareMatrix(1) }
    }

    @Test
    fun `matrice ok 10`() {
        assertDoesNotThrow { SquareMatrix(10) }
    }

    @Test
    fun `ordre matrice(5) = 5`() {
        assertEquals(5, SquareMatrix(5).order())
    }

    @Test
    fun `matrice nulle(5) est bien matrice  nulle`() {
        assertTrue(SquareMatrix(5).isNull())
    }


    @Test
    fun `id(5) n'est pas matrice nulle`() {
        var m = SquareMatrix(5)
        m.setAsIdentity()
        assertFalse(m.isNull())
    }

    @Test
    fun `id(5) est bien id`() {
        var m = SquareMatrix(5)
        m.setAsIdentity()
        assertTrue(m.isIdentity())
    }

    @Test
    fun `matrice nulle(5) n'est pas id`() {
        assertFalse(SquareMatrix(5).isIdentity())
    }

    @Test
    fun `random ko  # exception`() {
        assertThrows<IllegalArgumentException>{
            var m = SquareMatrix(5)
            m.randomize(10,-10)
        }
    }

    @Test
    fun `random ko =  # exception`() {
        assertThrows<IllegalArgumentException>{
            var m = SquareMatrix(5)
            m.randomize(3,3)
        }
    }

    @Test
    fun `random(5) n'est pas matrice nulle`() {
        var m = SquareMatrix(5)
        m.randomize(-10,10)
        assertFalse(m.isNull())
    }

    @Test
    fun `random(5) is id`() {
        var m = SquareMatrix(5)
        m.randomize(-10,10)
        assertFalse(m.isIdentity())
    }

    @Test
    fun `matrice nulle != id`() {
        var nulle = SquareMatrix(3)
        var id = SquareMatrix(3)
        id.setAsIdentity()
        assertTrue(nulle != id)
    }

    @Test
    fun `matrice nulle(3) == matrice nulle(3)`() {
        var nulle = SquareMatrix(3)
        var nulle2 = SquareMatrix(3)
        assertTrue(nulle == nulle)
    }

    @Test
    fun `mat nulle(3) != mat nulle(5)`() {
        var nulle = SquareMatrix(3)
        var nulle2 = SquareMatrix(5)
        assertTrue(nulle != nulle2)
    }

    @Test
    fun `id(3) == id(3)`() {
        var id = SquareMatrix(3)
        id.setAsIdentity()
        var id2 = SquareMatrix(3)
        id2.setAsIdentity()
        assertTrue(id == id2)
    }

    @Test
    fun `id(3) != id(5)`() {
        var id = SquareMatrix(3)
        id.setAsIdentity()
        var id2 = SquareMatrix(5)
        id2.setAsIdentity()
        assertTrue(id != id2)
    }

    @Test
    fun `mat nulle(3) != random(3)`() {
        var nulle = SquareMatrix(3)
        var random = SquareMatrix(3)
        random.randomize(-10,10)
        assertTrue(nulle != random)
    }

    @Test
    fun `id(3) != random(3)`() {
        var id = SquareMatrix(3)
        id.setAsIdentity()
        var random = SquareMatrix(3)
        random.randomize(-10,10)
        assertTrue(id != random)
    }

    @Test
    fun `mat nulle(1) == random(1)(0,1) ou id(1) == random(1)(0,1)`() {
        var nulle = SquareMatrix(1)
        var id = SquareMatrix(1)
        id.setAsIdentity()
        var random = SquareMatrix(1)
        random.randomize(0,1)
        assertTrue(nulle == random || id == random)
    }

    @Test
    fun `id(3) == id(3) + mat nulle(3)`() {
        var id = SquareMatrix(3)
        id.setAsIdentity()
        assertEquals(id, id + SquareMatrix(3))
    }

    @Test
    fun `id + id`() {
        var id = SquareMatrix(3)
        id.setAsIdentity()
        var id2 = SquareMatrix(3)
        id2.setAsIdentity()
        var m5 = id + id2
        println("# affiche la somme de 2 matrices identite")
        println(m5)
    }

    @Test
    fun `id(3) + mat nulle(3) == id(3)`() {
        var id = SquareMatrix(3)
        id.setAsIdentity()
        assertTrue(id + SquareMatrix(3) == id)
    }

    @Test
    fun `mat nulle x 5 == mat nulle`() {
        var nulle = SquareMatrix(5)
        assertEquals(nulle, nulle * 5)
    }

    @Test
    fun `id x 2`() {
        var id = SquareMatrix(5)
        id.setAsIdentity()
        var m4  = id * 2
        println("# affiche le produit de matrice identite * 2")
        println(m4)
    }

    @Test
    fun `id x 2 == id + id`() {
        var id = SquareMatrix(5)
        id.setAsIdentity()
        assertTrue(id * 2 == id + id)
    }

    @Test
    fun `random1 + random2`() {
        var random = SquareMatrix(5)
        random.randomize(-10,10)
        var random2 = SquareMatrix(5)
        random2.randomize(-5, 5)
        var result = random + random2
        println(result)
    }

    @Test
    fun `random + mat nulle = random`() {
        var nulle = SquareMatrix(5)
        var random = SquareMatrix(5)
        random.randomize(-10,10)
        assertEquals(random, random + nulle)
    }

    @Test
    fun `mat nulle(3) + mat nulle(5) #  # exception`() {
        var nulle3 = SquareMatrix(3)
        var nulle5 = SquareMatrix(5)
        assertThrows<ArithmeticException> {
            nulle3 + nulle5
        }
    }

    @Test
    fun `id(3) + id(5) #  # exception`() {
        var nulle3 = SquareMatrix(3)
        nulle3.setAsIdentity()
        var nulle5 = SquareMatrix(5)
        nulle5.setAsIdentity()
        assertThrows<ArithmeticException> {
            nulle3 + nulle5
        }
    }

    @Test
    fun `id(3) + random(5) #  # exception`() {
        var nulle3 = SquareMatrix(3)
        nulle3.setAsIdentity()
        var nulle5 = SquareMatrix(5)
        nulle5.randomize(-10,10)
        assertThrows<ArithmeticException> {
            nulle3 + nulle5
        }
    }

    @Test
    fun `id + -id = mat nulle`() {
        var id = SquareMatrix(5)
        id.setAsIdentity()
        assertEquals(SquareMatrix(5),  id + -id)
    }

    @Test
    fun `random + -random = mat nulle`() {
        var random = SquareMatrix(5)
        random.randomize(-10,10)
        assertEquals(SquareMatrix(5),random + -random)
    }

    @Test
    fun `id - id = mat nulle`() {
        var id = SquareMatrix(5)
        id.setAsIdentity()
        assertEquals(SquareMatrix(5), id - id)
    }

    @Test
    fun `random - random = mat nulle`() {
        var random = SquareMatrix(5)
        random.randomize(-10,10)
        assertEquals(SquareMatrix(5), random - random)
    }

    @Test
    fun `random - mat nulle = random`() {
        var nulle = SquareMatrix(5)
        var random = SquareMatrix(5)
        random.randomize(-10,10)
        assertEquals(random,random - nulle)
    }

    @Test
    fun `mat nulle - random = -random`() {
        var nulle = SquareMatrix(5)
        var random = SquareMatrix(5)
        random.randomize(-10,10)
        var _random = -random
        assertEquals(_random, nulle - random)
    }


    @Test
    fun `id(3) - id(5) #  # exception`() {
        var nulle3 = SquareMatrix(3)
        nulle3.setAsIdentity()
        var nulle5 = SquareMatrix(5)
        nulle5.setAsIdentity()
        assertThrows<ArithmeticException> {
            nulle3 - nulle5
        }
    }

    @Test
    fun `id(3) - random(5) #  # exception`() {
        var nulle3 = SquareMatrix(3)
        nulle3.setAsIdentity()
        var nulle5 = SquareMatrix(5)
        nulle5.randomize(-10,10)
        assertThrows<ArithmeticException> {
            nulle3 - nulle5
        }
    }

    @Test
    fun`(mat nulle transposee) == mat nulle`() {
        var m5 = SquareMatrix(5)
        var res = m5.transposite()
        assertEquals(m5, res)
    }

    @Test
    fun`(id transposee) == id`() {
        var m5 = SquareMatrix(5)
        m5.setAsIdentity()
        var res = m5.transposite()
        assertEquals(m5, res)
    }

    @Test
    fun`((id transposee) transpose) == id`() {
        var m5 = SquareMatrix(5)
        m5.setAsIdentity()
        var res = m5.transposite().transposite()
        assertEquals(m5, res)
    }

    @Test
    fun `((random transposee) transpose) == random`() {
        var m5 = SquareMatrix(5)
        m5.randomize(-10,10)
        var res = m5.transposite().transposite()
        assertEquals(m5, res)
    }

    @Test
    fun `mat nulle est symetrique`(){
        var m5 = SquareMatrix(5)
        assertTrue(m5.isSymetrical())
    }

    @Test
    fun `mat id est symetrique`(){
        var m5 = SquareMatrix(5)
        m5.setAsIdentity()
        assertTrue(m5.isSymetrical())
    }

    @Test
    fun `id + (transposee id) est symetrique`(){
        var m5 = SquareMatrix(5)
        m5.setAsIdentity()
        var t5 = m5.transposite()
        var res = m5 + t5
        assertTrue(res!!.isSymetrical())
    }

    @Test
    fun `random + (transposee random) est symetrique`(){
        var m5 = SquareMatrix(5)
        m5.randomize(-10,10)
        var t5 = m5.transposite()
        var res = m5 + t5
        assertTrue(res!!.isSymetrical())
    }

    @Test
    fun `mat nulle est antisymetrique`(){
        var m5 = SquareMatrix(5)
        assertTrue(m5.isAntiSymetrical())
    }

    @Test
    fun `mat id n'est pas antisymetrique`(){
        var m5 = SquareMatrix(5)
        m5.setAsIdentity()
        assertFalse(m5.isAntiSymetrical())
    }

    @Test
    fun `mat random n'est pas antisymetrique`(){
        var m5 = SquareMatrix(5)
        m5.randomize(-10, 10)
        var x5 = SquareMatrix(5)
        x5.setAsIdentity()
        assertFalse((m5 + x5)!!.isAntiSymetrical())
    }

    @Test
    fun `mat nulle x mat nulle = mat nulle`() {
        var m5 = SquareMatrix(5)
        var x5 = SquareMatrix(5)
        assertEquals(m5, m5 * x5)
    }

    @Test
    fun `mat nulle x id = mat nulle`() {
        var m5 = SquareMatrix(5)
        var x5 = SquareMatrix(5)
        x5.setAsIdentity()
        assertEquals(m5, m5 * x5)
    }

    @Test
    fun `id x mat nulle = mat nulle`() {
        var m5 = SquareMatrix(5)
        m5.setAsIdentity()
        var x5 = SquareMatrix(5)
        assertEquals(x5, m5 * x5)
    }

    @Test
    fun `mat nulle x random = mat nulle`() {
        var m5 = SquareMatrix(5)
        var x5 = SquareMatrix(5)
        x5.randomize(-10, 10)
        assertEquals(m5, m5 * x5)
    }

    @Test
    fun `random x mat nulle = mat nulle`() {
        var m5 = SquareMatrix(5)
        m5.randomize(-10, 10)
        var x5 = SquareMatrix(5)
        assertEquals(x5, m5 * x5)
    }

    @Test
    fun `id x random = random`() {
        var m5 = SquareMatrix(5)
        m5.setAsIdentity()
        var x5 = SquareMatrix(5)
        x5.randomize(-10, 10)
        assertEquals(x5, m5 * x5)
    }

    @Test
    fun `id x random x 2 = random x 2`() {
        var m5 = SquareMatrix(5)
        m5.setAsIdentity()
        var x5 = SquareMatrix(5)
        x5.randomize(-10, 10)
        assertEquals(x5 * 2, (m5 * x5)!! * 2)
    }

    @Test
    fun `random x id = random`() {
        var m5 = SquareMatrix(5)
        m5.randomize(-10, 10)
        var x5 = SquareMatrix(5)
        x5.setAsIdentity()
        assertEquals(m5, m5 * x5)
    }

    @Test
    fun `random1 x random2`() {
        var m5 = SquareMatrix(5)
        m5.randomize(-10, 10)
        var x5 = SquareMatrix(5)
        x5.randomize(-10, 10)
        var res = m5 * x5
        println(res)
    }

    @Test
    fun `(random1 x 2) x random2 = (random1 x random2) x 2`() {
        var m5 = SquareMatrix(5)
        m5.randomize(-10, 10)
        var x5 = SquareMatrix(5)
        x5.randomize(-10, 10)
        assertTrue( ((m5 * 2) * x5) == ((m5 * x5)!! * 2) )
    }

    @Test
    fun `random(5) x random(3) # exception`() {
        var m5 = SquareMatrix(5)
        m5.randomize(-10, 10)
        var x3 = SquareMatrix(3)
        x3.randomize(-10, 10)
        assertThrows<ArithmeticException>{
            m5 * x3
        }
    }

}