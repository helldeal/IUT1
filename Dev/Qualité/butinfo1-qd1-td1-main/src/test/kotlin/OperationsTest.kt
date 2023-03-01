import org.junit.jupiter.api.Test
import iut.but1.r203.td1.Operations
import org.junit.jupiter.api.Assertions.*
import kotlin.math.pow

internal class OperationsTest {

    @Test
    fun additionner( ) {
        assertEquals(3, Operations().additionner(arrayOf<Int>(1,2)))
    }
    @Test
    fun testAdditionner1( ){
        assertEquals(10, Operations().additionner(arrayOf<Int>(5,5)))
    }
    @Test
    fun testAdditionner2( ){
        assertEquals(15, Operations().additionner(arrayOf<Int>(5,5,5)))
    }
    @Test
    fun testAdditionner3( ){
        assertEquals(6, Operations().additionner(arrayOf<Int>(1,2,3)))
    }
    @Test
    fun testAdditionner4( ){
        assertEquals(6, Operations().additionner(arrayOf<Int>(2,1,3)))
    }
    @Test
    fun testAdditionner5( ){
        assertEquals(6, Operations().additionner(arrayOf<Int>(3,2,1)))
    }
    @Test
    fun testAdditionner6( ){
        assertEquals(0, Operations().additionner(arrayOf<Int>(0,0)))
    }
    @Test
    fun testAdditionner7( ){
        assertEquals(0, Operations().additionner(arrayOf<Int>(4,-4)))
    }
    @Test
    fun testAdditionner8( ){
        assertEquals(0, Operations().additionner(arrayOf<Int>(2,0,-2)))
    }

    @Test
    fun testSoustraireVide() {
        assertEquals(0, Operations().soustraire(arrayOf()))
    }
    @Test
    fun testSoustraire1() {
        assertEquals(0, Operations().soustraire(arrayOf<Int>(3,3)))
    }
    @Test
    fun testSoustraire2() {
        assertEquals(-3, Operations().soustraire(arrayOf<Int>(3,3,3)))
    }
    @Test
    fun testSoustraire3() {
        assertEquals(-4, Operations().soustraire(arrayOf<Int>(1,2,3)))
    }
    @Test
    fun testSoustraire4() {
        assertEquals(-2, Operations().soustraire(arrayOf<Int>(2,1,3)))
    }
    @Test
    fun testSoustraire5() {
        assertEquals(0, Operations().soustraire(arrayOf<Int>(3,2,1)))
    }
    @Test
    fun testSoustraire6() {
        assertEquals(0, Operations().soustraire(arrayOf<Int>(0,0)))
    }
    @Test
    fun testSoustraire7() {
        assertEquals(-10, Operations().soustraire(arrayOf<Int>(-5,5)))
    }
    @Test
    fun testSoustraire8() {
        assertEquals(-4, Operations().soustraire(arrayOf<Int>(-2,0,2)))
    }


    @Test
    fun testMultiplier1() {
        assertEquals(9, Operations().multiplier(arrayOf<Int>(3,3)))
    }
    @Test
    fun testMultiplier2() {
        assertEquals(27, Operations().multiplier(arrayOf<Int>(3,3,3)))
    }
    @Test
    fun testMultiplier3() {
        assertEquals(6, Operations().multiplier(arrayOf<Int>(1,2,3)))
    }
    @Test
    fun testMultiplier4() {
        assertEquals(6, Operations().multiplier(arrayOf<Int>(2,1,3)))
    }
    @Test
    fun testMultiplier5() {
        assertEquals(6, Operations().multiplier(arrayOf<Int>(3,2,1)))
    }
    @Test
    fun testMultiplier6() {
        assertEquals(0, Operations().multiplier(arrayOf<Int>(0,0)))
    }
    @Test
    fun testMultiplier7() {
        assertEquals(-25, Operations().multiplier(arrayOf<Int>(-5,5)))
    }
    @Test
    fun testMultiplier8() {
        assertEquals(0, Operations().multiplier(arrayOf<Int>(-2,0,2)))
    }

    @Test
    fun testMultiplier30() {
        assertEquals(2.toDouble().pow(30).toInt() , Operations().multiplier(arrayOf<Int>(2.toDouble().pow(29).toInt(),2)))
    }
    @Test
    fun testMultiplier31() {
        assertEquals(2.toDouble().pow(31).toInt(), Operations().multiplier(arrayOf<Int>(2.toDouble().pow(29).toInt(),4)))
    }
    @Test
    fun testMultiplier32() {
        assertEquals(2.toDouble().pow(32).toInt(), Operations().multiplier(arrayOf<Int>(2.toDouble().pow(29).toInt(),8)))
    }
    @Test
    fun testMultiplier33() {
        assertEquals(2.toDouble().pow(33).toInt(), Operations().multiplier(arrayOf<Int>(2.toDouble().pow(29).toInt(),16)))
    }
}