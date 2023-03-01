import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberFunctions

class TestObjetGraphique {

    val kClass = ObjetGraphique::class

    @Test
    fun `ObjetGraphique verif`() {
        assertAll(
            {assertFalse(kClass.isOpen)},
            {assertTrue(kClass.isAbstract)},
        )
    }

    @Test
    fun `ObjetGraphique verif 2`() {
        var extend = kClass.allSuperclasses.find{it.simpleName == "Selectionnable"}
        assertNotNull(extend)
    }

}
