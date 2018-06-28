import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("UNUSED_EXPRESSION")
internal class SherlockTest {

    val sherlock = Sherlock()

    @ParameterizedTest
    @ValueSource(strings = [ "abcdefa","aabbccdda","abbbcccddd" ])
    fun `is valid string when only one letter is off`(word: String) {
        "given a valid string"
        val valid = sherlock.isValid(word)

        "then isValid should return YES"
        Assertions.assertEquals("YES", valid)
    }

    @ParameterizedTest
    @ValueSource(strings = [ "abbcccdddd","aaabbbdd","aaaaabc" ])
    internal fun `string with random number of characters should be invalid`(invalidWord:String) {
        "given an invalid string with growing number of characters"
        val valid = sherlock.isValid(invalidWord)


        "then isValid should return NO"
        Assertions.assertEquals("NO", valid)
    }
}