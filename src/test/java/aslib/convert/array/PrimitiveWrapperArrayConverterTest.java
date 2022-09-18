package aslib.convert.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link PrimitiveWrapperArrayConverter} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class PrimitiveWrapperArrayConverterTest {

    @Test
    void toPrimitive_ReturnsByteArray_WhenSuccessful() {
        byte[] array = PrimitiveWrapperArrayConverter.toPrimitive(new Byte[]{1, 2, 3});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new byte[]{1, 2, 3}, array);
    }

    @Test
    void toPrimitive_ReturnsCharArray_WhenSuccessful() {
        char[] array = PrimitiveWrapperArrayConverter.toPrimitive(new Character[]{'1', '2', '3'});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new char[]{'1', '2', '3'}, array);
    }

    @Test
    void toPrimitive_ReturnsDoubleArray_WhenSuccessful() {
        double[] array = PrimitiveWrapperArrayConverter.toPrimitive(new Double[]{1.0, 2.0, 3.0});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, array);
    }

    @Test
    void toPrimitive_ReturnsFloatArray_WhenSuccessful() {
        float[] array = PrimitiveWrapperArrayConverter.toPrimitive(new Float[]{1.0F, 2.0F, 3.0F});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new float[]{1.0F, 2.0F, 3.0F}, array);
    }

    @Test
    void toPrimitive_ReturnsIntArray_WhenSuccessful() {
        int[] array = PrimitiveWrapperArrayConverter.toPrimitive(new Integer[]{1, 2, 3});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new int[]{1, 2, 3}, array);
    }

    @Test
    void toPrimitive_ReturnsLongArray_WhenSuccessful() {
        long[] array = PrimitiveWrapperArrayConverter.toPrimitive(new Long[]{1L, 2L, 3L});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new long[]{1L, 2L, 3L}, array);
    }

    @Test
    void toPrimitive_ReturnsShortArray_WhenSuccessful() {
        short[] array = PrimitiveWrapperArrayConverter.toPrimitive(new Short[]{1, 2, 3});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new short[]{1, 2, 3}, array);
    }

    @Test
    @SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
    void toPrimitive_ThrowsNullPointerException_WhenArrayIsNull() {
        Byte[] bytes = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toPrimitive(bytes),
                     "Byte failed");

        Short[] shorts = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toPrimitive(shorts),
                     "Short failed");

        Integer[] integers = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toPrimitive(integers),
                     "Integer failed");

        Long[] longs = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toPrimitive(longs),
                     "Long failed");

        Float[] floats = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toPrimitive(floats),
                     "Float failed");

        Double[] doubles = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toPrimitive(doubles),
                     "Double failed");

        Character[] characters = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toPrimitive(characters),
                     "Character failed");
    }


    @Test
    void toWrapper_ReturnsByteArray_WhenSuccessful() {
        Byte[] array = PrimitiveWrapperArrayConverter.toWrapper(new byte[]{1, 2, 3});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new Byte[]{1, 2, 3}, array);
    }

    @Test
    void toWrapper_ReturnsCharArray_WhenSuccessful() {
        Character[] array = PrimitiveWrapperArrayConverter.toWrapper(new char[]{'1', '2', '3'});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new Character[]{'1', '2', '3'}, array);
    }

    @Test
    void toWrapper_ReturnsDoubleArray_WhenSuccessful() {
        Double[] array = PrimitiveWrapperArrayConverter.toWrapper(new double[]{1.0, 2.0, 3.0});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new Double[]{1.0, 2.0, 3.0}, array);
    }

    @Test
    void toWrapper_ReturnsFloatArray_WhenSuccessful() {
        Float[] array = PrimitiveWrapperArrayConverter.toWrapper(new float[]{1.0F, 2.0F, 3.0F});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new Float[]{1.0F, 2.0F, 3.0F}, array);
    }

    @Test
    void toWrapper_ReturnsIntArray_WhenSuccessful() {
        Integer[] array = PrimitiveWrapperArrayConverter.toWrapper(new int[]{1, 2, 3});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    void toWrapper_ReturnsLongArray_WhenSuccessful() {
        Long[] array = PrimitiveWrapperArrayConverter.toWrapper(new long[]{1L, 2L, 3L});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new Long[]{1L, 2L, 3L}, array);
    }

    @Test
    void toWrapper_ReturnsShortArray_WhenSuccessful() {
        Short[] array = PrimitiveWrapperArrayConverter.toWrapper(new short[]{1, 2, 3});

        assertNotNull(array);
        assertEquals(3, array.length);
        assertArrayEquals(new Short[]{1, 2, 3}, array);
    }

    @SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
    @Test
    void toWrapper_ThrowsNullPointerException_WhenArrayIsNull() {
        byte[] bytes = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toWrapper(bytes),
                     "Byte failed");

        short[] shorts = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toWrapper(shorts),
                     "Short failed");

        int[] integers = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toWrapper(integers),
                     "Integer failed");

        long[] longs = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toWrapper(longs),
                     "Long failed");

        float[] floats = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toWrapper(floats),
                     "Float failed");

        double[] doubles = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toWrapper(doubles),
                     "Double failed");

        char[] characters = null;
        assertThrows(NullPointerException.class,
                     () -> PrimitiveWrapperArrayConverter.toWrapper(characters),
                     "Character failed");
    }
}
