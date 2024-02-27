package space.springbok.bslimageservice.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FileUtilsTest {

    @Test
    void testfileNameLengthEqualOrSmallerThanFour() {
        String result = FileUtils.generateOptimizedFileName("abcd.jpg");
        assertThat(result).isEqualTo("/thumbnail/abcd.jpg");
    }

    @Test
    void testFileNameLenghtGreaterThanEight() {
        String result = FileUtils.generateOptimizedFileName("abcdefghij.jpg");
        assertThat(result).isEqualTo("/thumbnail/abcd/efgh/abcdefghij.jpg");
    }

    @Test
    void testFileNameLengthGreaterThanEightWithForwardSlashes() {
        String result = FileUtils.generateOptimizedFileName("/somedir/anotherdir/abcdef.jpg");
        assertThat(result).isEqualTo("/thumbnail/_som/edir/_somedir_anotherdir_abcdef.jpg");
    }

    @Test
    void testFileNameLengthGreaterFourAndSmallerOrEqualsThanEight() {
        String result = FileUtils.generateOptimizedFileName("abcde.jpg");
        assertThat(result).isEqualTo("/thumbnail/abcd/abcde.jpg");
    }


}