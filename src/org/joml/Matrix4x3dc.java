package org.joml;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public interface Matrix4x3dc {

    /**
     * Bit returned by {@link #properties()} to indicate that the matrix represents the identity transformation.
     */
    byte PROPERTY_IDENTITY = 1<<2;
    /**
     * Bit returned by {@link #properties()} to indicate that the matrix represents a pure translation transformation.
     */
    byte PROPERTY_TRANSLATION = 1<<3;

    /**
     * @return the properties of the matrix
     */
    byte properties();

    /**
     * Return the value of the matrix element at column 0 and row 0.
     * 
     * @return the value of the matrix element
     */
    double m00();

    /**
     * Return the value of the matrix element at column 0 and row 1.
     * 
     * @return the value of the matrix element
     */
    double m01();

    /**
     * Return the value of the matrix element at column 0 and row 2.
     * 
     * @return the value of the matrix element
     */
    double m02();

    /**
     * Return the value of the matrix element at column 1 and row 0.
     * 
     * @return the value of the matrix element
     */
    double m10();

    /**
     * Return the value of the matrix element at column 1 and row 1.
     * 
     * @return the value of the matrix element
     */
    double m11();

    /**
     * Return the value of the matrix element at column 1 and row 2.
     * 
     * @return the value of the matrix element
     */
    double m12();

    /**
     * Return the value of the matrix element at column 2 and row 0.
     * 
     * @return the value of the matrix element
     */
    double m20();

    /**
     * Return the value of the matrix element at column 2 and row 1.
     * 
     * @return the value of the matrix element
     */
    double m21();

    /**
     * Return the value of the matrix element at column 2 and row 2.
     * 
     * @return the value of the matrix element
     */
    double m22();

    /**
     * Return the value of the matrix element at column 3 and row 0.
     * 
     * @return the value of the matrix element
     */
    double m30();

    /**
     * Return the value of the matrix element at column 3 and row 1.
     * 
     * @return the value of the matrix element
     */
    double m31();

    /**
     * Return the value of the matrix element at column 3 and row 2.
     * 
     * @return the value of the matrix element
     */
    double m32();

    /**
     * Get the current values of <code>this</code> matrix and store them into the upper 4x3 submatrix of <code>dest</code>.
     * <p>
     * The other elements of <code>dest</code> will not be modified.
     * 
     * @see Matrix4d#set4x3(Matrix4x3dc)
     * 
     * @param dest
     *            the destination matrix
     * @return dest
     */
    Matrix4d get(Matrix4d dest);

    /**
     * Multiply this matrix by the supplied <code>right</code> matrix and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the <code>right</code> matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * transformation of the right matrix will be applied first!
     * 
     * @param right
     *          the right operand of the multiplication
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d mul(Matrix4x3dc right, Matrix4x3d dest);

    /**
     * Multiply this matrix, which is assumed to only contain a translation, by the supplied <code>right</code> matrix and store the result in <code>dest</code>.
     * <p>
     * This method assumes that <code>this</code> matrix only contains a translation.
     * <p>
     * This method will not modify either the last row of <code>this</code> or the last row of <code>right</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the <code>right</code> matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * transformation of the right matrix will be applied first!
     *
     * @param right
     *          the right operand of the matrix multiplication
     * @param dest
     *          the destination matrix, which will hold the result
     * @return dest
     */
    Matrix4x3d mulTranslation(Matrix4x3dc right, Matrix4x3d dest);

    /**
     * Multiply <code>this</code> orthographic projection matrix by the supplied <code>view</code> matrix
     * and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>V</code> the <code>view</code> matrix,
     * then the new matrix will be <code>M * V</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * V * v</code>, the
     * transformation of the <code>view</code> matrix will be applied first!
     *
     * @param view
     *          the matrix which to multiply <code>this</code> with
     * @param dest
     *          the destination matrix, which will hold the result
     * @return dest
     */
    Matrix4x3d mulOrtho(Matrix4x3dc view, Matrix4x3d dest);

    /**
     * Component-wise add <code>this</code> and <code>other</code>
     * by first multiplying each component of <code>other</code> by <code>otherFactor</code>,
     * adding that to <code>this</code> and storing the final result in <code>dest</code>.
     * <p>
     * The other components of <code>dest</code> will be set to the ones of <code>this</code>.
     * <p>
     * The matrices <code>this</code> and <code>other</code> will not be changed.
     * 
     * @param other
     *          the other matrix 
     * @param otherFactor
     *          the factor to multiply each of the other matrix's components
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d fma(Matrix4x3dc other, double otherFactor, Matrix4x3d dest);

    /**
     * Component-wise add <code>this</code> and <code>other</code> and store the result in <code>dest</code>.
     * 
     * @param other
     *          the other addend
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d add(Matrix4x3dc other, Matrix4x3d dest);

    /**
     * Component-wise subtract <code>subtrahend</code> from <code>this</code> and store the result in <code>dest</code>.
     * 
     * @param subtrahend
     *          the subtrahend
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d sub(Matrix4x3dc subtrahend, Matrix4x3d dest);

    /**
     * Component-wise multiply <code>this</code> by <code>other</code> and store the result in <code>dest</code>.
     * 
     * @param other
     *          the other matrix
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d mulComponentWise(Matrix4x3dc other, Matrix4x3d dest);

    /**
     * Return the determinant of this matrix.
     * 
     * @return the determinant
     */
    double determinant();

    /**
     * Invert <code>this</code> matrix and store the result in <code>dest</code>.
     * 
     * @param dest
     *             will hold the result
     * @return dest
     */
    Matrix4x3d invert(Matrix4x3d dest);

    /**
     * Invert <code>this</code> orthographic projection matrix and store the result into the given <code>dest</code>.
     * <p>
     * This method can be used to quickly obtain the inverse of an orthographic projection matrix.
     * 
     * @param dest
     *          will hold the inverse of <code>this</code>
     * @return dest
     */
    Matrix4x3d invertOrtho(Matrix4x3d dest);

    /**
     * Invert this matrix by assuming that it has unit scaling (i.e. {@link #transformDirection(Vector3d) transformDirection}
     * does not change the {@link Vector3dc#length() length} of the vector) and write the result into <code>dest</code>.
     * <p>
     * Reference: <a href="http://www.gamedev.net/topic/425118-inverse--matrix/">http://www.gamedev.net/</a>
     * 
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d invertUnitScale(Matrix4x3d dest);

    /**
     * Transpose only the left 3x3 submatrix of this matrix and store the result in <code>dest</code>.
     * <p>
     * All other matrix elements are left unchanged.
     * 
     * @param dest
     *             will hold the result
     * @return dest
     */
    Matrix4x3d transpose3x3(Matrix4x3d dest);

    /**
     * Transpose only the left 3x3 submatrix of this matrix and store the result in <code>dest</code>.
     * 
     * @param dest
     *             will hold the result
     * @return dest
     */
    Matrix3d transpose3x3(Matrix3d dest);

    /**
     * Get only the translation components <tt>(m30, m31, m32)</tt> of this matrix and store them in the given vector <code>xyz</code>.
     * 
     * @param dest
     *          will hold the translation components of this matrix
     * @return dest
     */
    Vector3d getTranslation(Vector3d dest);

    /**
     * Get the scaling factors of <code>this</code> matrix for the three base axes.
     * 
     * @param dest
     *          will hold the scaling factors for <tt>x</tt>, <tt>y</tt> and <tt>z</tt>
     * @return dest
     */
    Vector3d getScale(Vector3d dest);

    /**
     * Get the current values of <code>this</code> matrix and store them into
     * <code>dest</code>.
     * 
     * @param dest
     *          the destination matrix
     * @return the passed in destination
     */
    Matrix4x3d get(Matrix4x3d dest);

    /**
     * Get the current values of <code>this</code> matrix and store the represented rotation
     * into the given {@link Quaternionf}.
     * <p>
     * This method assumes that the first three column vectors of the left 3x3 submatrix are not normalized and
     * thus allows to ignore any additional scaling factor that is applied to the matrix.
     * 
     * @see Quaternionf#setFromUnnormalized(Matrix4x3dc)
     * 
     * @param dest
     *          the destination {@link Quaternionf}
     * @return the passed in destination
     */
    Quaternionf getUnnormalizedRotation(Quaternionf dest);

    /**
     * Get the current values of <code>this</code> matrix and store the represented rotation
     * into the given {@link Quaternionf}.
     * <p>
     * This method assumes that the first three column vectors of the left 3x3 submatrix are normalized.
     * 
     * @see Quaternionf#setFromNormalized(Matrix4x3dc)
     * 
     * @param dest
     *          the destination {@link Quaternionf}
     * @return the passed in destination
     */
    Quaternionf getNormalizedRotation(Quaternionf dest);

    /**
     * Get the current values of <code>this</code> matrix and store the represented rotation
     * into the given {@link Quaterniond}.
     * <p>
     * This method assumes that the first three column vectors of the left 3x3 submatrix are not normalized and
     * thus allows to ignore any additional scaling factor that is applied to the matrix.
     * 
     * @see Quaterniond#setFromUnnormalized(Matrix4x3dc)
     * 
     * @param dest
     *          the destination {@link Quaterniond}
     * @return the passed in destination
     */
    Quaterniond getUnnormalizedRotation(Quaterniond dest);

    /**
     * Get the current values of <code>this</code> matrix and store the represented rotation
     * into the given {@link Quaterniond}.
     * <p>
     * This method assumes that the first three column vectors of the left 3x3 submatrix are normalized.
     * 
     * @see Quaterniond#setFromNormalized(Matrix4x3dc)
     * 
     * @param dest
     *          the destination {@link Quaterniond}
     * @return the passed in destination
     */
    Quaterniond getNormalizedRotation(Quaterniond dest);

    /**
     * Store this matrix in column-major order into the supplied {@link DoubleBuffer} at the current
     * buffer {@link DoubleBuffer#position() position}.
     * <p>
     * This method will not increment the position of the given DoubleBuffer.
     * <p>
     * In order to specify the offset into the DoubleBuffer at which
     * the matrix is stored, use {@link #get(int, DoubleBuffer)}, taking
     * the absolute position as parameter.
     * 
     * @see #get(int, DoubleBuffer)
     * 
     * @param buffer
     *            will receive the values of this matrix in column-major order at its current position
     * @return the passed in buffer
     */
    DoubleBuffer get(DoubleBuffer buffer);

    /**
     * Store this matrix in column-major order into the supplied {@link DoubleBuffer} starting at the specified
     * absolute buffer position/index.
     * <p>
     * This method will not increment the position of the given {@link DoubleBuffer}.
     * 
     * @param index
     *            the absolute position into the {@link DoubleBuffer}
     * @param buffer
     *            will receive the values of this matrix in column-major order
     * @return the passed in buffer
     */
    DoubleBuffer get(int index, DoubleBuffer buffer);

    /**
     * Store this matrix in column-major order into the supplied {@link FloatBuffer} at the current
     * buffer {@link FloatBuffer#position() position}.
     * <p>
     * This method will not increment the position of the given
     * FloatBuffer.
     * <p>
     * In order to specify the offset into the FloatBuffer at which
     * the matrix is stored, use {@link #get(int, FloatBuffer)}, taking
     * the absolute position as parameter.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given FloatBuffer.
     * 
     * @see #get(int, FloatBuffer)
     * 
     * @param buffer
     *            will receive the values of this matrix in column-major order at its current position
     * @return the passed in buffer
     */
    FloatBuffer get(FloatBuffer buffer);

    /**
     * Store this matrix in column-major order into the supplied {@link FloatBuffer} starting at the specified
     * absolute buffer position/index.
     * <p>
     * This method will not increment the position of the given FloatBuffer.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given FloatBuffer.
     * 
     * @param index
     *            the absolute position into the FloatBuffer
     * @param buffer
     *            will receive the values of this matrix in column-major order
     * @return the passed in buffer
     */
    FloatBuffer get(int index, FloatBuffer buffer);

    /**
     * Store this matrix in column-major order into the supplied {@link ByteBuffer} at the current
     * buffer {@link ByteBuffer#position() position}.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * <p>
     * In order to specify the offset into the ByteBuffer at which
     * the matrix is stored, use {@link #get(int, ByteBuffer)}, taking
     * the absolute position as parameter.
     * 
     * @see #get(int, ByteBuffer)
     * 
     * @param buffer
     *            will receive the values of this matrix in column-major order at its current position
     * @return the passed in buffer
     */
    ByteBuffer get(ByteBuffer buffer);

    /**
     * Store this matrix in column-major order into the supplied {@link ByteBuffer} starting at the specified
     * absolute buffer position/index.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * 
     * @param index
     *            the absolute position into the ByteBuffer
     * @param buffer
     *            will receive the values of this matrix in column-major order
     * @return the passed in buffer
     */
    ByteBuffer get(int index, ByteBuffer buffer);

    /**
     * Store the elements of this matrix as float values in column-major order into the supplied {@link ByteBuffer} at the current
     * buffer {@link ByteBuffer#position() position}.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given ByteBuffer.
     * <p>
     * In order to specify the offset into the ByteBuffer at which
     * the matrix is stored, use {@link #getFloats(int, ByteBuffer)}, taking
     * the absolute position as parameter.
     * 
     * @see #getFloats(int, ByteBuffer)
     * 
     * @param buffer
     *            will receive the elements of this matrix as float values in column-major order at its current position
     * @return the passed in buffer
     */
    ByteBuffer getFloats(ByteBuffer buffer);

    /**
     * Store the elements of this matrix as float values in column-major order into the supplied {@link ByteBuffer}
     * starting at the specified absolute buffer position/index.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given ByteBuffer.
     * 
     * @param index
     *            the absolute position into the ByteBuffer
     * @param buffer
     *            will receive the elements of this matrix as float values in column-major order
     * @return the passed in buffer
     */
    ByteBuffer getFloats(int index, ByteBuffer buffer);

    /**
     * Store this matrix into the supplied double array in column-major order at the given offset.
     * 
     * @param arr
     *          the array to write the matrix values into
     * @param offset
     *          the offset into the array
     * @return the passed in array
     */
    double[] get(double[] arr, int offset);

    /**
     * Store this matrix into the supplied double array in column-major order.
     * <p>
     * In order to specify an explicit offset into the array, use the method {@link #get(double[], int)}.
     * 
     * @see #get(double[], int)
     * 
     * @param arr
     *          the array to write the matrix values into
     * @return the passed in array
     */
    double[] get(double[] arr);

    /**
     * Store the elements of this matrix as float values in column-major order into the supplied float array at the given offset.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given float array.
     * 
     * @param arr
     *          the array to write the matrix values into
     * @param offset
     *          the offset into the array
     * @return the passed in array
     */
    float[] get(float[] arr, int offset);

    /**
     * Store the elements of this matrix as float values in column-major order into the supplied float array.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given float array.
     * <p>
     * In order to specify an explicit offset into the array, use the method {@link #get(float[], int)}.
     * 
     * @see #get(float[], int)
     * 
     * @param arr
     *          the array to write the matrix values into
     * @return the passed in array
     */
    float[] get(float[] arr);

    /**
     * Store a 4x4 matrix in column-major order into the supplied {@link DoubleBuffer} at the current
     * buffer {@link DoubleBuffer#position() position}, where the upper 4x3 submatrix is <code>this</code> and the last row is <tt>(0, 0, 0, 1)</tt>.
     * <p>
     * This method will not increment the position of the given DoubleBuffer.
     * <p>
     * In order to specify the offset into the DoubleBuffer at which
     * the matrix is stored, use {@link #get4x4(int, DoubleBuffer)}, taking
     * the absolute position as parameter.
     * 
     * @see #get4x4(int, DoubleBuffer)
     * 
     * @param buffer
     *            will receive the values of this matrix in column-major order at its current position
     * @return the passed in buffer
     */
    DoubleBuffer get4x4(DoubleBuffer buffer);

    /**
     * Store a 4x4 matrix in column-major order into the supplied {@link DoubleBuffer} starting at the specified
     * absolute buffer position/index, where the upper 4x3 submatrix is <code>this</code> and the last row is <tt>(0, 0, 0, 1)</tt>.
     * <p>
     * This method will not increment the position of the given DoubleBuffer.
     * 
     * @param index
     *            the absolute position into the DoubleBuffer
     * @param buffer
     *            will receive the values of this matrix in column-major order
     * @return the passed in buffer
     */
    DoubleBuffer get4x4(int index, DoubleBuffer buffer);

    /**
     * Store a 4x4 matrix in column-major order into the supplied {@link ByteBuffer} at the current
     * buffer {@link ByteBuffer#position() position}, where the upper 4x3 submatrix is <code>this</code> and the last row is <tt>(0, 0, 0, 1)</tt>.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * <p>
     * In order to specify the offset into the ByteBuffer at which
     * the matrix is stored, use {@link #get4x4(int, ByteBuffer)}, taking
     * the absolute position as parameter.
     * 
     * @see #get4x4(int, ByteBuffer)
     * 
     * @param buffer
     *            will receive the values of this matrix in column-major order at its current position
     * @return the passed in buffer
     */
    ByteBuffer get4x4(ByteBuffer buffer);

    /**
     * Store a 4x4 matrix in column-major order into the supplied {@link ByteBuffer} starting at the specified
     * absolute buffer position/index, where the upper 4x3 submatrix is <code>this</code> and the last row is <tt>(0, 0, 0, 1)</tt>.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * 
     * @param index
     *            the absolute position into the ByteBuffer
     * @param buffer
     *            will receive the values of this matrix in column-major order
     * @return the passed in buffer
     */
    ByteBuffer get4x4(int index, ByteBuffer buffer);

    /**
     * Store this matrix in row-major order into the supplied {@link DoubleBuffer} at the current
     * buffer {@link DoubleBuffer#position() position}.
     * <p>
     * This method will not increment the position of the given DoubleBuffer.
     * <p>
     * In order to specify the offset into the DoubleBuffer at which
     * the matrix is stored, use {@link #getTransposed(int, DoubleBuffer)}, taking
     * the absolute position as parameter.
     * 
     * @see #getTransposed(int, DoubleBuffer)
     * 
     * @param buffer
     *            will receive the values of this matrix in row-major order at its current position
     * @return the passed in buffer
     */
    DoubleBuffer getTransposed(DoubleBuffer buffer);

    /**
     * Store this matrix in row-major order into the supplied {@link DoubleBuffer} starting at the specified
     * absolute buffer position/index.
     * <p>
     * This method will not increment the position of the given DoubleBuffer.
     * 
     * @param index
     *            the absolute position into the DoubleBuffer
     * @param buffer
     *            will receive the values of this matrix in row-major order
     * @return the passed in buffer
     */
    DoubleBuffer getTransposed(int index, DoubleBuffer buffer);

    /**
     * Store this matrix in row-major order into the supplied {@link ByteBuffer} at the current
     * buffer {@link ByteBuffer#position() position}.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * <p>
     * In order to specify the offset into the ByteBuffer at which
     * the matrix is stored, use {@link #getTransposed(int, ByteBuffer)}, taking
     * the absolute position as parameter.
     * 
     * @see #getTransposed(int, ByteBuffer)
     * 
     * @param buffer
     *            will receive the values of this matrix in row-major order at its current position
     * @return the passed in buffer
     */
    ByteBuffer getTransposed(ByteBuffer buffer);

    /**
     * Store this matrix in row-major order into the supplied {@link ByteBuffer} starting at the specified
     * absolute buffer position/index.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * 
     * @param index
     *            the absolute position into the ByteBuffer
     * @param buffer
     *            will receive the values of this matrix in row-major order
     * @return the passed in buffer
     */
    ByteBuffer getTransposed(int index, ByteBuffer buffer);

    /**
     * Store this matrix in row-major order into the supplied {@link FloatBuffer} at the current
     * buffer {@link FloatBuffer#position() position}.
     * <p>
     * This method will not increment the position of the given FloatBuffer.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given FloatBuffer.
     * <p>
     * In order to specify the offset into the FloatBuffer at which
     * the matrix is stored, use {@link #getTransposed(int, FloatBuffer)}, taking
     * the absolute position as parameter.
     * 
     * @see #getTransposed(int, FloatBuffer)
     * 
     * @param buffer
     *            will receive the values of this matrix in row-major order at its current position
     * @return the passed in buffer
     */
    FloatBuffer getTransposed(FloatBuffer buffer);

    /**
     * Store this matrix in row-major order into the supplied {@link FloatBuffer} starting at the specified
     * absolute buffer position/index.
     * <p>
     * This method will not increment the position of the given FloatBuffer.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given FloatBuffer.
     * 
     * @param index
     *            the absolute position into the FloatBuffer
     * @param buffer
     *            will receive the values of this matrix in row-major order
     * @return the passed in buffer
     */
    FloatBuffer getTransposed(int index, FloatBuffer buffer);

    /**
     * Store this matrix as float values in row-major order into the supplied {@link ByteBuffer} at the current
     * buffer {@link ByteBuffer#position() position}.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given FloatBuffer.
     * <p>
     * In order to specify the offset into the ByteBuffer at which
     * the matrix is stored, use {@link #getTransposedFloats(int, ByteBuffer)}, taking
     * the absolute position as parameter.
     * 
     * @see #getTransposedFloats(int, ByteBuffer)
     * 
     * @param buffer
     *            will receive the values of this matrix as float values in row-major order at its current position
     * @return the passed in buffer
     */
    ByteBuffer getTransposedFloats(ByteBuffer buffer);

    /**
     * Store this matrix in row-major order into the supplied {@link ByteBuffer} starting at the specified
     * absolute buffer position/index.
     * <p>
     * This method will not increment the position of the given ByteBuffer.
     * <p>
     * Please note that due to this matrix storing double values those values will potentially
     * lose precision when they are converted to float values before being put into the given FloatBuffer.
     * 
     * @param index
     *            the absolute position into the ByteBuffer
     * @param buffer
     *            will receive the values of this matrix as float values in row-major order
     * @return the passed in buffer
     */
    ByteBuffer getTransposedFloats(int index, ByteBuffer buffer);

    /**
     * Store this matrix into the supplied float array in row-major order at the given offset.
     * 
     * @param arr
     *          the array to write the matrix values into
     * @param offset
     *          the offset into the array
     * @return the passed in array
     */
    double[] getTransposed(double[] arr, int offset);

    /**
     * Store this matrix into the supplied float array in row-major order.
     * <p>
     * In order to specify an explicit offset into the array, use the method {@link #getTransposed(double[], int)}.
     * 
     * @see #getTransposed(double[], int)
     * 
     * @param arr
     *          the array to write the matrix values into
     * @return the passed in array
     */
    double[] getTransposed(double[] arr);

    /**
     * Transform/multiply the given vector by this matrix and store the result in that vector.
     * 
     * @see Vector4d#mul(Matrix4x3dc)
     * 
     * @param v
     *          the vector to transform and to hold the final result
     * @return v
     */
    Vector4d transform(Vector4d v);

    /**
     * Transform/multiply the given vector by this matrix and store the result in <code>dest</code>.
     * 
     * @see Vector4d#mul(Matrix4x3dc, Vector4d)
     * 
     * @param v
     *          the vector to transform
     * @param dest
     *          will contain the result
     * @return dest
     */
    Vector4d transform(Vector4dc v, Vector4d dest);

    /**
     * Transform/multiply the given 3D-vector, as if it was a 4D-vector with w=1, by
     * this matrix and store the result in that vector.
     * <p>
     * The given 3D-vector is treated as a 4D-vector with its w-component being 1.0, so it
     * will represent a position/location in 3D-space rather than a direction.
     * <p>
     * In order to store the result in another vector, use {@link #transformPosition(Vector3dc, Vector3d)}.
     * 
     * @see #transformPosition(Vector3dc, Vector3d)
     * @see #transform(Vector4d)
     * 
     * @param v
     *          the vector to transform and to hold the final result
     * @return v
     */
    Vector3d transformPosition(Vector3d v);

    /**
     * Transform/multiply the given 3D-vector, as if it was a 4D-vector with w=1, by
     * this matrix and store the result in <code>dest</code>.
     * <p>
     * The given 3D-vector is treated as a 4D-vector with its w-component being 1.0, so it
     * will represent a position/location in 3D-space rather than a direction.
     * <p>
     * In order to store the result in the same vector, use {@link #transformPosition(Vector3d)}.
     * 
     * @see #transformPosition(Vector3d)
     * @see #transform(Vector4dc, Vector4d)
     * 
     * @param v
     *          the vector to transform
     * @param dest
     *          will hold the result
     * @return dest
     */
    Vector3d transformPosition(Vector3dc v, Vector3d dest);

    /**
     * Transform/multiply the given 3D-vector, as if it was a 4D-vector with w=0, by
     * this matrix and store the result in that vector.
     * <p>
     * The given 3D-vector is treated as a 4D-vector with its w-component being <tt>0.0</tt>, so it
     * will represent a direction in 3D-space rather than a position. This method will therefore
     * not take the translation part of the matrix into account.
     * <p>
     * In order to store the result in another vector, use {@link #transformDirection(Vector3dc, Vector3d)}.
     * 
     * @param v
     *          the vector to transform and to hold the final result
     * @return v
     */
    Vector3d transformDirection(Vector3d v);

    /**
     * Transform/multiply the given 3D-vector, as if it was a 4D-vector with w=0, by
     * this matrix and store the result in <code>dest</code>.
     * <p>
     * The given 3D-vector is treated as a 4D-vector with its w-component being <tt>0.0</tt>, so it
     * will represent a direction in 3D-space rather than a position. This method will therefore
     * not take the translation part of the matrix into account.
     * <p>
     * In order to store the result in the same vector, use {@link #transformDirection(Vector3d)}.
     * 
     * @param v
     *          the vector to transform and to hold the final result
     * @param dest
     *          will hold the result
     * @return dest
     */
    Vector3d transformDirection(Vector3dc v, Vector3d dest);

    /**
     * Apply scaling to <code>this</code> matrix by scaling the base axes by the given <tt>xyz.x</tt>,
     * <tt>xyz.y</tt> and <tt>xyz.z</tt> factors, respectively and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the scaling matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>
     * , the scaling will be applied first!
     * 
     * @param xyz
     *            the factors of the x, y and z component, respectively
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d scale(Vector3dc xyz, Matrix4x3d dest);

    /**
     * Apply scaling to <code>this</code> matrix by scaling the base axes by the given x,
     * y and z factors and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the scaling matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>
     * , the scaling will be applied first!
     * 
     * @param x
     *            the factor of the x component
     * @param y
     *            the factor of the y component
     * @param z
     *            the factor of the z component
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d scale(double x, double y, double z, Matrix4x3d dest);

    /**
     * Apply scaling to this matrix by uniformly scaling all base axes by the given xyz factor
     * and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the scaling matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>
     * , the scaling will be applied first!
     * 
     * @see #scale(double, double, double, Matrix4x3d)
     * 
     * @param xyz
     *            the factor for all components
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d scale(double xyz, Matrix4x3d dest);

    /**
     * Pre-multiply scaling to <code>this</code> matrix by scaling the base axes by the given x,
     * y and z factors and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the scaling matrix,
     * then the new matrix will be <code>S * M</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>S * M * v</code>
     * , the scaling will be applied last!
     * 
     * @param x
     *            the factor of the x component
     * @param y
     *            the factor of the y component
     * @param z
     *            the factor of the z component
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d scaleLocal(double x, double y, double z, Matrix4x3d dest);

    /**
     * Apply rotation to this matrix by rotating the given amount of radians
     * about the given axis specified as x, y and z components and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>
     * , the rotation will be applied first!
     * 
     * @param ang
     *            the angle is in radians
     * @param x
     *            the x component of the axis
     * @param y
     *            the y component of the axis
     * @param z
     *            the z component of the axis
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d rotate(double ang, double x, double y, double z, Matrix4x3d dest);

    /**
     * Apply rotation to this matrix, which is assumed to only contain a translation, by rotating the given amount of radians
     * about the specified <tt>(x, y, z)</tt> axis and store the result in <code>dest</code>.
     * <p>
     * This method assumes <code>this</code> to only contain a translation.
     * <p>
     * The axis described by the three components needs to be a unit vector.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Rotation_matrix_from_axis_and_angle">http://en.wikipedia.org</a>
     * 
     * @param ang
     *            the angle in radians
     * @param x
     *            the x component of the axis
     * @param y
     *            the y component of the axis
     * @param z
     *            the z component of the axis
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d rotateTranslation(double ang, double x, double y, double z, Matrix4x3d dest);

    /**
     * Pre-multiply a rotation to this matrix by rotating the given amount of radians
     * about the specified <tt>(x, y, z)</tt> axis and store the result in <code>dest</code>.
     * <p>
     * The axis described by the three components needs to be a unit vector.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>R * M</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>R * M * v</code>, the
     * rotation will be applied last!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Rotation_matrix_from_axis_and_angle">http://en.wikipedia.org</a>
     * 
     * @param ang
     *            the angle in radians
     * @param x
     *            the x component of the axis
     * @param y
     *            the y component of the axis
     * @param z
     *            the z component of the axis
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d rotateLocal(double ang, double x, double y, double z, Matrix4x3d dest);

    /**
     * Apply a translation to this matrix by translating by the given number of
     * units in x, y and z and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>T</code> the translation
     * matrix, then the new matrix will be <code>M * T</code>. So when
     * transforming a vector <code>v</code> with the new matrix by using
     * <code>M * T * v</code>, the translation will be applied first!
     * 
     * @param offset
     *          the number of units in x, y and z by which to translate
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d translate(Vector3dc offset, Matrix4x3d dest);

    /**
     * Apply a translation to this matrix by translating by the given number of
     * units in x, y and z and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>T</code> the translation
     * matrix, then the new matrix will be <code>M * T</code>. So when
     * transforming a vector <code>v</code> with the new matrix by using
     * <code>M * T * v</code>, the translation will be applied first!
     * 
     * @param offset
     *          the number of units in x, y and z by which to translate
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d translate(Vector3fc offset, Matrix4x3d dest);

    /**
     * Apply a translation to this matrix by translating by the given number of
     * units in x, y and z and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>T</code> the translation
     * matrix, then the new matrix will be <code>M * T</code>. So when
     * transforming a vector <code>v</code> with the new matrix by using
     * <code>M * T * v</code>, the translation will be applied first!
     * 
     * @param x
     *          the offset to translate in x
     * @param y
     *          the offset to translate in y
     * @param z
     *          the offset to translate in z
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d translate(double x, double y, double z, Matrix4x3d dest);

    /**
     * Pre-multiply a translation to this matrix by translating by the given number of
     * units in x, y and z and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>T</code> the translation
     * matrix, then the new matrix will be <code>T * M</code>. So when
     * transforming a vector <code>v</code> with the new matrix by using
     * <code>T * M * v</code>, the translation will be applied last!
     * 
     * @param offset
     *          the number of units in x, y and z by which to translate
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d translateLocal(Vector3fc offset, Matrix4x3d dest);

    /**
     * Pre-multiply a translation to this matrix by translating by the given number of
     * units in x, y and z and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>T</code> the translation
     * matrix, then the new matrix will be <code>T * M</code>. So when
     * transforming a vector <code>v</code> with the new matrix by using
     * <code>T * M * v</code>, the translation will be applied last!
     * 
     * @param offset
     *          the number of units in x, y and z by which to translate
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d translateLocal(Vector3dc offset, Matrix4x3d dest);

    /**
     * Pre-multiply a translation to this matrix by translating by the given number of
     * units in x, y and z and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>T</code> the translation
     * matrix, then the new matrix will be <code>T * M</code>. So when
     * transforming a vector <code>v</code> with the new matrix by using
     * <code>T * M * v</code>, the translation will be applied last!
     * 
     * @param x
     *          the offset to translate in x
     * @param y
     *          the offset to translate in y
     * @param z
     *          the offset to translate in z
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d translateLocal(double x, double y, double z, Matrix4x3d dest);

    /**
     * Apply rotation about the X axis to this matrix by rotating the given amount of radians 
     * and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Basic_rotations">http://en.wikipedia.org</a>
     * 
     * @param ang
     *            the angle in radians
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d rotateX(double ang, Matrix4x3d dest);

    /**
     * Apply rotation about the Y axis to this matrix by rotating the given amount of radians 
     * and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Basic_rotations">http://en.wikipedia.org</a>
     * 
     * @param ang
     *            the angle in radians
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d rotateY(double ang, Matrix4x3d dest);

    /**
     * Apply rotation about the Z axis to this matrix by rotating the given amount of radians 
     * and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Basic_rotations">http://en.wikipedia.org</a>
     * 
     * @param ang
     *            the angle in radians
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d rotateZ(double ang, Matrix4x3d dest);

    /**
     * Apply rotation of <code>angleX</code> radians about the X axis, followed by a rotation of <code>angleY</code> radians about the Y axis and
     * followed by a rotation of <code>angleZ</code> radians about the Z axis and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * rotation will be applied first!
     * <p>
     * This method is equivalent to calling: <tt>rotateX(angleX, dest).rotateY(angleY).rotateZ(angleZ)</tt>
     * 
     * @param angleX
     *            the angle to rotate about X
     * @param angleY
     *            the angle to rotate about Y
     * @param angleZ
     *            the angle to rotate about Z
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d rotateXYZ(double angleX, double angleY, double angleZ, Matrix4x3d dest);

    /**
     * Apply rotation of <code>angleZ</code> radians about the Z axis, followed by a rotation of <code>angleY</code> radians about the Y axis and
     * followed by a rotation of <code>angleX</code> radians about the X axis and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * rotation will be applied first!
     * <p>
     * This method is equivalent to calling: <tt>rotateZ(angleZ, dest).rotateY(angleY).rotateX(angleX)</tt>
     * 
     * @param angleZ
     *            the angle to rotate about Z
     * @param angleY
     *            the angle to rotate about Y
     * @param angleX
     *            the angle to rotate about X
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d rotateZYX(double angleZ, double angleY, double angleX, Matrix4x3d dest);

    /**
     * Apply rotation of <code>angleY</code> radians about the Y axis, followed by a rotation of <code>angleX</code> radians about the X axis and
     * followed by a rotation of <code>angleZ</code> radians about the Z axis and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * rotation will be applied first!
     * <p>
     * This method is equivalent to calling: <tt>rotateY(angleY, dest).rotateX(angleX).rotateZ(angleZ)</tt>
     * 
     * @param angleY
     *            the angle to rotate about Y
     * @param angleX
     *            the angle to rotate about X
     * @param angleZ
     *            the angle to rotate about Z
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d rotateYXZ(double angleY, double angleX, double angleZ, Matrix4x3d dest);

    /**
     * Apply the rotation transformation of the given {@link Quaterniond} to this matrix and store
     * the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>Q</code> the rotation matrix obtained from the given quaternion,
     * then the new matrix will be <code>M * Q</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * Q * v</code>,
     * the quaternion rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Quaternion">http://en.wikipedia.org</a>
     * 
     * @param quat
     *          the {@link Quaterniond}
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotate(Quaterniond quat, Matrix4x3d dest);

    /**
     * Apply the rotation transformation of the given {@link Quaternionfc} to this matrix and store
     * the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>Q</code> the rotation matrix obtained from the given quaternion,
     * then the new matrix will be <code>M * Q</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * Q * v</code>,
     * the quaternion rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Quaternion">http://en.wikipedia.org</a>
     * 
     * @param quat
     *          the {@link Quaternionfc}
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotate(Quaternionfc quat, Matrix4x3d dest);

    /**
     * Apply the rotation transformation of the given {@link Quaterniond} to this matrix, which is assumed to only contain a translation, and store
     * the result in <code>dest</code>.
     * <p>
     * This method assumes <code>this</code> to only contain a translation.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>Q</code> the rotation matrix obtained from the given quaternion,
     * then the new matrix will be <code>M * Q</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * Q * v</code>,
     * the quaternion rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Quaternion">http://en.wikipedia.org</a>
     * 
     * @param quat
     *          the {@link Quaterniond}
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotateTranslation(Quaterniond quat, Matrix4x3d dest);

    /**
     * Apply the rotation transformation of the given {@link Quaternionfc} to this matrix, which is assumed to only contain a translation, and store
     * the result in <code>dest</code>.
     * <p>
     * This method assumes <code>this</code> to only contain a translation.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>Q</code> the rotation matrix obtained from the given quaternion,
     * then the new matrix will be <code>M * Q</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * Q * v</code>,
     * the quaternion rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Quaternion">http://en.wikipedia.org</a>
     * 
     * @param quat
     *          the {@link Quaternionfc}
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotateTranslation(Quaternionfc quat, Matrix4x3d dest);

    /**
     * Pre-multiply the rotation transformation of the given {@link Quaterniond} to this matrix and store
     * the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>Q</code> the rotation matrix obtained from the given quaternion,
     * then the new matrix will be <code>Q * M</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>Q * M * v</code>,
     * the quaternion rotation will be applied last!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Quaternion">http://en.wikipedia.org</a>
     * 
     * @param quat
     *          the {@link Quaterniond}
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotateLocal(Quaterniond quat, Matrix4x3d dest);

    /**
     * Pre-multiply the rotation transformation of the given {@link Quaternionfc} to this matrix and store
     * the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>Q</code> the rotation matrix obtained from the given quaternion,
     * then the new matrix will be <code>Q * M</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>Q * M * v</code>,
     * the quaternion rotation will be applied last!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Quaternion">http://en.wikipedia.org</a>
     * 
     * @param quat
     *          the {@link Quaternionfc}
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotateLocal(Quaternionfc quat, Matrix4x3d dest);

    /**
     * Apply a rotation transformation, rotating about the given {@link AxisAngle4f} and store the result in <code>dest</code>.
     * <p>
     * The axis described by the <code>axis</code> vector needs to be a unit vector.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>A</code> the rotation matrix obtained from the given {@link AxisAngle4f},
     * then the new matrix will be <code>M * A</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * A * v</code>,
     * the {@link AxisAngle4f} rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Axis_and_angle">http://en.wikipedia.org</a>
     * 
     * @see #rotate(double, double, double, double, Matrix4x3d)
     * 
     * @param axisAngle
     *          the {@link AxisAngle4f} (needs to be {@link AxisAngle4f#normalize() normalized})
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotate(AxisAngle4f axisAngle, Matrix4x3d dest);

    /**
     * Apply a rotation transformation, rotating about the given {@link AxisAngle4d} and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>A</code> the rotation matrix obtained from the given {@link AxisAngle4d},
     * then the new matrix will be <code>M * A</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * A * v</code>,
     * the {@link AxisAngle4d} rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Axis_and_angle">http://en.wikipedia.org</a>
     * 
     * @see #rotate(double, double, double, double, Matrix4x3d)
     * 
     * @param axisAngle
     *          the {@link AxisAngle4d} (needs to be {@link AxisAngle4d#normalize() normalized})
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotate(AxisAngle4d axisAngle, Matrix4x3d dest);

    /**
     * Apply a rotation transformation, rotating the given radians about the specified axis and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>A</code> the rotation matrix obtained from the given angle and axis,
     * then the new matrix will be <code>M * A</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * A * v</code>,
     * the axis-angle rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Axis_and_angle">http://en.wikipedia.org</a>
     * 
     * @see #rotate(double, double, double, double, Matrix4x3d)
     * 
     * @param angle
     *          the angle in radians
     * @param axis
     *          the rotation axis (needs to be {@link Vector3d#normalize() normalized})
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotate(double angle, Vector3dc axis, Matrix4x3d dest);

    /**
     * Apply a rotation transformation, rotating the given radians about the specified axis and store the result in <code>dest</code>.
     * <p>
     * When used with a right-handed coordinate system, the produced rotation will rotate a vector 
     * counter-clockwise around the rotation axis, when viewing along the negative axis direction towards the origin.
     * When used with a left-handed coordinate system, the rotation is clockwise.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>A</code> the rotation matrix obtained from the given angle and axis,
     * then the new matrix will be <code>M * A</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * A * v</code>,
     * the axis-angle rotation will be applied first!
     * <p>
     * Reference: <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Axis_and_angle">http://en.wikipedia.org</a>
     * 
     * @see #rotate(double, double, double, double, Matrix4x3d)
     * 
     * @param angle
     *          the angle in radians
     * @param axis
     *          the rotation axis (needs to be {@link Vector3f#normalize() normalized})
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d rotate(double angle, Vector3fc axis, Matrix4x3d dest);

    /**
     * Get the row at the given <code>row</code> index, starting with <code>0</code>.
     * 
     * @param row
     *          the row index in <tt>[0..2]</tt>
     * @param dest
     *          will hold the row components
     * @return the passed in destination
     * @throws IndexOutOfBoundsException if <code>row</code> is not in <tt>[0..2]</tt>
     */
    Vector4d getRow(int row, Vector4d dest) throws IndexOutOfBoundsException;

    /**
     * Get the column at the given <code>column</code> index, starting with <code>0</code>.
     * 
     * @param column
     *          the column index in <tt>[0..3]</tt>
     * @param dest
     *          will hold the column components
     * @return the passed in destination
     * @throws IndexOutOfBoundsException if <code>column</code> is not in <tt>[0..3]</tt>
     */
    Vector3d getColumn(int column, Vector3d dest) throws IndexOutOfBoundsException;

    /**
     * Compute a normal matrix from the left 3x3 submatrix of <code>this</code>
     * and store it into the left 3x3 submatrix of <code>dest</code>.
     * All other values of <code>dest</code> will be set to identity.
     * <p>
     * The normal matrix of <tt>m</tt> is the transpose of the inverse of <tt>m</tt>.
     * 
     * @param dest
     *             will hold the result
     * @return dest
     */
    Matrix4x3d normal(Matrix4x3d dest);

    /**
     * Compute a normal matrix from the left 3x3 submatrix of <code>this</code>
     * and store it into <code>dest</code>.
     * <p>
     * The normal matrix of <tt>m</tt> is the transpose of the inverse of <tt>m</tt>.
     * 
     * @param dest
     *             will hold the result
     * @return dest
     */
    Matrix3d normal(Matrix3d dest);

    /**
     * Normalize the left 3x3 submatrix of this matrix and store the result in <code>dest</code>.
     * <p>
     * The resulting matrix will map unit vectors to unit vectors, though a pair of orthogonal input unit
     * vectors need not be mapped to a pair of orthogonal output vectors if the original matrix was not orthogonal itself
     * (i.e. had <i>skewing</i>).
     * 
     * @param dest
     *             will hold the result
     * @return dest
     */
    Matrix4x3d normalize3x3(Matrix4x3d dest);

    /**
     * Normalize the left 3x3 submatrix of this matrix and store the result in <code>dest</code>.
     * <p>
     * The resulting matrix will map unit vectors to unit vectors, though a pair of orthogonal input unit
     * vectors need not be mapped to a pair of orthogonal output vectors if the original matrix was not orthogonal itself
     * (i.e. had <i>skewing</i>).
     * 
     * @param dest
     *             will hold the result
     * @return dest
     */
    Matrix3d normalize3x3(Matrix3d dest);

    /**
     * Apply a mirror/reflection transformation to this matrix that reflects about the given plane
     * specified via the equation <tt>x*a + y*b + z*c + d = 0</tt> and store the result in <code>dest</code>.
     * <p>
     * The vector <tt>(a, b, c)</tt> must be a unit vector.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the reflection matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * reflection will be applied first!
     * <p>
     * Reference: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/bb281733(v=vs.85).aspx">msdn.microsoft.com</a>
     * 
     * @param a
     *          the x factor in the plane equation
     * @param b
     *          the y factor in the plane equation
     * @param c
     *          the z factor in the plane equation
     * @param d
     *          the constant in the plane equation
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d reflect(double a, double b, double c, double d, Matrix4x3d dest);

    /**
     * Apply a mirror/reflection transformation to this matrix that reflects about the given plane
     * specified via the plane normal and a point on the plane, and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the reflection matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * reflection will be applied first!
     * 
     * @param nx
     *          the x-coordinate of the plane normal
     * @param ny
     *          the y-coordinate of the plane normal
     * @param nz
     *          the z-coordinate of the plane normal
     * @param px
     *          the x-coordinate of a point on the plane
     * @param py
     *          the y-coordinate of a point on the plane
     * @param pz
     *          the z-coordinate of a point on the plane
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d reflect(double nx, double ny, double nz, double px, double py, double pz, Matrix4x3d dest);

    /**
     * Apply a mirror/reflection transformation to this matrix that reflects about a plane
     * specified via the plane orientation and a point on the plane, and store the result in <code>dest</code>.
     * <p>
     * This method can be used to build a reflection transformation based on the orientation of a mirror object in the scene.
     * It is assumed that the default mirror plane's normal is <tt>(0, 0, 1)</tt>. So, if the given {@link Quaterniond} is
     * the identity (does not apply any additional rotation), the reflection plane will be <tt>z=0</tt>, offset by the given <code>point</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the reflection matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * reflection will be applied first!
     * 
     * @param orientation
     *          the plane orientation
     * @param point
     *          a point on the plane
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d reflect(Quaterniond orientation, Vector3dc point, Matrix4x3d dest);

    /**
     * Apply a mirror/reflection transformation to this matrix that reflects about the given plane
     * specified via the plane normal and a point on the plane, and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the reflection matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * reflection will be applied first!
     * 
     * @param normal
     *          the plane normal
     * @param point
     *          a point on the plane
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d reflect(Vector3dc normal, Vector3dc point, Matrix4x3d dest);

    /**
     * Apply an orthographic projection transformation for a right-handed coordinate system
     * using the given NDC z range to this matrix and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @param left
     *            the distance from the center to the left frustum edge
     * @param right
     *            the distance from the center to the right frustum edge
     * @param bottom
     *            the distance from the center to the bottom frustum edge
     * @param top
     *            the distance from the center to the top frustum edge
     * @param zNear
     *            near clipping plane distance
     * @param zFar
     *            far clipping plane distance
     * @param zZeroToOne
     *            whether to use Vulkan's and Direct3D's NDC z range of <tt>[0..+1]</tt> when <code>true</code>
     *            or whether to use OpenGL's NDC z range of <tt>[-1..+1]</tt> when <code>false</code>
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d ortho(double left, double right, double bottom, double top, double zNear, double zFar, boolean zZeroToOne, Matrix4x3d dest);

    /**
     * Apply an orthographic projection transformation for a right-handed coordinate system
     * using OpenGL's NDC z range of <tt>[-1..+1]</tt> to this matrix and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @param left
     *            the distance from the center to the left frustum edge
     * @param right
     *            the distance from the center to the right frustum edge
     * @param bottom
     *            the distance from the center to the bottom frustum edge
     * @param top
     *            the distance from the center to the top frustum edge
     * @param zNear
     *            near clipping plane distance
     * @param zFar
     *            far clipping plane distance
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d ortho(double left, double right, double bottom, double top, double zNear, double zFar, Matrix4x3d dest);

    /**
     * Apply an orthographic projection transformation for a left-handed coordiante system
     * using the given NDC z range to this matrix and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @param left
     *            the distance from the center to the left frustum edge
     * @param right
     *            the distance from the center to the right frustum edge
     * @param bottom
     *            the distance from the center to the bottom frustum edge
     * @param top
     *            the distance from the center to the top frustum edge
     * @param zNear
     *            near clipping plane distance
     * @param zFar
     *            far clipping plane distance
     * @param zZeroToOne
     *            whether to use Vulkan's and Direct3D's NDC z range of <tt>[0..+1]</tt> when <code>true</code>
     *            or whether to use OpenGL's NDC z range of <tt>[-1..+1]</tt> when <code>false</code>
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d orthoLH(double left, double right, double bottom, double top, double zNear, double zFar, boolean zZeroToOne, Matrix4x3d dest);

    /**
     * Apply an orthographic projection transformation for a left-handed coordiante system
     * using OpenGL's NDC z range of <tt>[-1..+1]</tt> to this matrix and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @param left
     *            the distance from the center to the left frustum edge
     * @param right
     *            the distance from the center to the right frustum edge
     * @param bottom
     *            the distance from the center to the bottom frustum edge
     * @param top
     *            the distance from the center to the top frustum edge
     * @param zNear
     *            near clipping plane distance
     * @param zFar
     *            far clipping plane distance
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d orthoLH(double left, double right, double bottom, double top, double zNear, double zFar, Matrix4x3d dest);

    /**
     * Apply a symmetric orthographic projection transformation for a right-handed coordinate system
     * using the given NDC z range to this matrix and store the result in <code>dest</code>.
     * <p>
     * This method is equivalent to calling {@link #ortho(double, double, double, double, double, double, boolean, Matrix4x3d) ortho()} with
     * <code>left=-width/2</code>, <code>right=+width/2</code>, <code>bottom=-height/2</code> and <code>top=+height/2</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @param width
     *            the distance between the right and left frustum edges
     * @param height
     *            the distance between the top and bottom frustum edges
     * @param zNear
     *            near clipping plane distance
     * @param zFar
     *            far clipping plane distance
     * @param dest
     *            will hold the result
     * @param zZeroToOne
     *            whether to use Vulkan's and Direct3D's NDC z range of <tt>[0..+1]</tt> when <code>true</code>
     *            or whether to use OpenGL's NDC z range of <tt>[-1..+1]</tt> when <code>false</code>
     * @return dest
     */
    Matrix4x3d orthoSymmetric(double width, double height, double zNear, double zFar, boolean zZeroToOne, Matrix4x3d dest);

    /**
     * Apply a symmetric orthographic projection transformation for a right-handed coordinate system
     * using OpenGL's NDC z range of <tt>[-1..+1]</tt> to this matrix and store the result in <code>dest</code>.
     * <p>
     * This method is equivalent to calling {@link #ortho(double, double, double, double, double, double, Matrix4x3d) ortho()} with
     * <code>left=-width/2</code>, <code>right=+width/2</code>, <code>bottom=-height/2</code> and <code>top=+height/2</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @param width
     *            the distance between the right and left frustum edges
     * @param height
     *            the distance between the top and bottom frustum edges
     * @param zNear
     *            near clipping plane distance
     * @param zFar
     *            far clipping plane distance
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d orthoSymmetric(double width, double height, double zNear, double zFar, Matrix4x3d dest);

    /**
     * Apply a symmetric orthographic projection transformation for a left-handed coordinate system
     * using the given NDC z range to this matrix and store the result in <code>dest</code>.
     * <p>
     * This method is equivalent to calling {@link #orthoLH(double, double, double, double, double, double, boolean, Matrix4x3d) orthoLH()} with
     * <code>left=-width/2</code>, <code>right=+width/2</code>, <code>bottom=-height/2</code> and <code>top=+height/2</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @param width
     *            the distance between the right and left frustum edges
     * @param height
     *            the distance between the top and bottom frustum edges
     * @param zNear
     *            near clipping plane distance
     * @param zFar
     *            far clipping plane distance
     * @param dest
     *            will hold the result
     * @param zZeroToOne
     *            whether to use Vulkan's and Direct3D's NDC z range of <tt>[0..+1]</tt> when <code>true</code>
     *            or whether to use OpenGL's NDC z range of <tt>[-1..+1]</tt> when <code>false</code>
     * @return dest
     */
    Matrix4x3d orthoSymmetricLH(double width, double height, double zNear, double zFar, boolean zZeroToOne, Matrix4x3d dest);

    /**
     * Apply a symmetric orthographic projection transformation for a left-handed coordinate system
     * using OpenGL's NDC z range of <tt>[-1..+1]</tt> to this matrix and store the result in <code>dest</code>.
     * <p>
     * This method is equivalent to calling {@link #orthoLH(double, double, double, double, double, double, Matrix4x3d) orthoLH()} with
     * <code>left=-width/2</code>, <code>right=+width/2</code>, <code>bottom=-height/2</code> and <code>top=+height/2</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @param width
     *            the distance between the right and left frustum edges
     * @param height
     *            the distance between the top and bottom frustum edges
     * @param zNear
     *            near clipping plane distance
     * @param zFar
     *            far clipping plane distance
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d orthoSymmetricLH(double width, double height, double zNear, double zFar, Matrix4x3d dest);

    /**
     * Apply an orthographic projection transformation for a right-handed coordinate system
     * to this matrix and store the result in <code>dest</code>.
     * <p>
     * This method is equivalent to calling {@link #ortho(double, double, double, double, double, double, Matrix4x3d) ortho()} with
     * <code>zNear=-1</code> and <code>zFar=+1</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @see #ortho(double, double, double, double, double, double, Matrix4x3d)
     * 
     * @param left
     *            the distance from the center to the left frustum edge
     * @param right
     *            the distance from the center to the right frustum edge
     * @param bottom
     *            the distance from the center to the bottom frustum edge
     * @param top
     *            the distance from the center to the top frustum edge
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d ortho2D(double left, double right, double bottom, double top, Matrix4x3d dest);

    /**
     * Apply an orthographic projection transformation for a left-handed coordinate system to this matrix and store the result in <code>dest</code>.
     * <p>
     * This method is equivalent to calling {@link #orthoLH(double, double, double, double, double, double, Matrix4x3d) orthoLH()} with
     * <code>zNear=-1</code> and <code>zFar=+1</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>O</code> the orthographic projection matrix,
     * then the new matrix will be <code>M * O</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * O * v</code>, the
     * orthographic projection transformation will be applied first!
     * <p>
     * Reference: <a href="http://www.songho.ca/opengl/gl_projectionmatrix.html#ortho">http://www.songho.ca</a>
     * 
     * @see #orthoLH(double, double, double, double, double, double, Matrix4x3d)
     * 
     * @param left
     *            the distance from the center to the left frustum edge
     * @param right
     *            the distance from the center to the right frustum edge
     * @param bottom
     *            the distance from the center to the bottom frustum edge
     * @param top
     *            the distance from the center to the top frustum edge
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d ortho2DLH(double left, double right, double bottom, double top, Matrix4x3d dest);

    /**
     * Apply a rotation transformation to this matrix to make <code>-z</code> point along <code>dir</code>
     * and store the result in <code>dest</code>. 
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>L</code> the lookalong rotation matrix,
     * then the new matrix will be <code>M * L</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * L * v</code>, the
     * lookalong rotation transformation will be applied first!
     * <p>
     * This is equivalent to calling
     * {@link #lookAt(Vector3dc, Vector3dc, Vector3dc, Matrix4x3d) lookAt}
     * with <code>eye = (0, 0, 0)</code> and <code>center = dir</code>.
     * 
     * @see #lookAlong(double, double, double, double, double, double, Matrix4x3d)
     * @see #lookAt(Vector3dc, Vector3dc, Vector3dc, Matrix4x3d)
     * 
     * @param dir
     *            the direction in space to look along
     * @param up
     *            the direction of 'up'
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d lookAlong(Vector3dc dir, Vector3dc up, Matrix4x3d dest);

    /**
     * Apply a rotation transformation to this matrix to make <code>-z</code> point along <code>dir</code>
     * and store the result in <code>dest</code>. 
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>L</code> the lookalong rotation matrix,
     * then the new matrix will be <code>M * L</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * L * v</code>, the
     * lookalong rotation transformation will be applied first!
     * <p>
     * This is equivalent to calling
     * {@link #lookAt(double, double, double, double, double, double, double, double, double, Matrix4x3d) lookAt()}
     * with <code>eye = (0, 0, 0)</code> and <code>center = dir</code>.
     * 
     * @see #lookAt(double, double, double, double, double, double, double, double, double, Matrix4x3d)
     * 
     * @param dirX
     *              the x-coordinate of the direction to look along
     * @param dirY
     *              the y-coordinate of the direction to look along
     * @param dirZ
     *              the z-coordinate of the direction to look along
     * @param upX
     *              the x-coordinate of the up vector
     * @param upY
     *              the y-coordinate of the up vector
     * @param upZ
     *              the z-coordinate of the up vector
     * @param dest
     *              will hold the result
     * @return dest
     */
    Matrix4x3d lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, Matrix4x3d dest);

    /**
     * Apply a "lookat" transformation to this matrix for a right-handed coordinate system, 
     * that aligns <code>-z</code> with <code>center - eye</code> and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>L</code> the lookat matrix,
     * then the new matrix will be <code>M * L</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * L * v</code>,
     * the lookat transformation will be applied first!
     * 
     * @see #lookAt(double, double, double, double, double, double, double, double, double, Matrix4x3d)
     * 
     * @param eye
     *            the position of the camera
     * @param center
     *            the point in space to look at
     * @param up
     *            the direction of 'up'
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d lookAt(Vector3dc eye, Vector3dc center, Vector3dc up, Matrix4x3d dest);

    /**
     * Apply a "lookat" transformation to this matrix for a right-handed coordinate system, 
     * that aligns <code>-z</code> with <code>center - eye</code> and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>L</code> the lookat matrix,
     * then the new matrix will be <code>M * L</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * L * v</code>,
     * the lookat transformation will be applied first!
     * 
     * @see #lookAt(Vector3dc, Vector3dc, Vector3dc, Matrix4x3d)
     * 
     * @param eyeX
     *              the x-coordinate of the eye/camera location
     * @param eyeY
     *              the y-coordinate of the eye/camera location
     * @param eyeZ
     *              the z-coordinate of the eye/camera location
     * @param centerX
     *              the x-coordinate of the point to look at
     * @param centerY
     *              the y-coordinate of the point to look at
     * @param centerZ
     *              the z-coordinate of the point to look at
     * @param upX
     *              the x-coordinate of the up vector
     * @param upY
     *              the y-coordinate of the up vector
     * @param upZ
     *              the z-coordinate of the up vector
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d lookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Matrix4x3d dest);

    /**
     * Apply a "lookat" transformation to this matrix for a left-handed coordinate system, 
     * that aligns <code>+z</code> with <code>center - eye</code> and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>L</code> the lookat matrix,
     * then the new matrix will be <code>M * L</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * L * v</code>,
     * the lookat transformation will be applied first!
     * 
     * @see #lookAtLH(double, double, double, double, double, double, double, double, double, Matrix4x3d)
     * 
     * @param eye
     *            the position of the camera
     * @param center
     *            the point in space to look at
     * @param up
     *            the direction of 'up'
     * @param dest
     *            will hold the result
     * @return dest
     */
    Matrix4x3d lookAtLH(Vector3dc eye, Vector3dc center, Vector3dc up, Matrix4x3d dest);

    /**
     * Apply a "lookat" transformation to this matrix for a left-handed coordinate system, 
     * that aligns <code>+z</code> with <code>center - eye</code> and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>L</code> the lookat matrix,
     * then the new matrix will be <code>M * L</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * L * v</code>,
     * the lookat transformation will be applied first!
     * 
     * @see #lookAtLH(Vector3dc, Vector3dc, Vector3dc, Matrix4x3d)
     * 
     * @param eyeX
     *              the x-coordinate of the eye/camera location
     * @param eyeY
     *              the y-coordinate of the eye/camera location
     * @param eyeZ
     *              the z-coordinate of the eye/camera location
     * @param centerX
     *              the x-coordinate of the point to look at
     * @param centerY
     *              the y-coordinate of the point to look at
     * @param centerZ
     *              the z-coordinate of the point to look at
     * @param upX
     *              the x-coordinate of the up vector
     * @param upY
     *              the y-coordinate of the up vector
     * @param upZ
     *              the z-coordinate of the up vector
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d lookAtLH(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Matrix4x3d dest);

    /**
     * Obtain the direction of <tt>+Z</tt> before the transformation represented by <code>this</code> matrix is applied.
     * <p>
     * This method uses the rotation component of the left 3x3 submatrix to obtain the direction 
     * that is transformed to <tt>+Z</tt> by <code>this</code> matrix.
     * <p>
     * This method is equivalent to the following code:
     * <pre>
     * Matrix4x3d inv = new Matrix4x3d(this).invert();
     * inv.transformDirection(dir.set(0, 0, 1)).normalize();
     * </pre>
     * If <code>this</code> is already an orthogonal matrix, then consider using {@link #normalizedPositiveZ(Vector3d)} instead.
     * <p>
     * Reference: <a href="http://www.euclideanspace.com/maths/algebra/matrix/functions/inverse/threeD/">http://www.euclideanspace.com</a>
     * 
     * @param dir
     *          will hold the direction of <tt>+Z</tt>
     * @return dir
     */
    Vector3d positiveZ(Vector3d dir);

    /**
     * Obtain the direction of <tt>+Z</tt> before the transformation represented by <code>this</code> <i>orthogonal</i> matrix is applied.
     * This method only produces correct results if <code>this</code> is an <i>orthogonal</i> matrix.
     * <p>
     * This method uses the rotation component of the left 3x3 submatrix to obtain the direction 
     * that is transformed to <tt>+Z</tt> by <code>this</code> matrix.
     * <p>
     * This method is equivalent to the following code:
     * <pre>
     * Matrix4x3d inv = new Matrix4x3d(this).transpose();
     * inv.transformDirection(dir.set(0, 0, 1)).normalize();
     * </pre>
     * <p>
     * Reference: <a href="http://www.euclideanspace.com/maths/algebra/matrix/functions/inverse/threeD/">http://www.euclideanspace.com</a>
     * 
     * @param dir
     *          will hold the direction of <tt>+Z</tt>
     * @return dir
     */
    Vector3d normalizedPositiveZ(Vector3d dir);

    /**
     * Obtain the direction of <tt>+X</tt> before the transformation represented by <code>this</code> matrix is applied.
     * <p>
     * This method uses the rotation component of the left 3x3 submatrix to obtain the direction 
     * that is transformed to <tt>+X</tt> by <code>this</code> matrix.
     * <p>
     * This method is equivalent to the following code:
     * <pre>
     * Matrix4x3d inv = new Matrix4x3d(this).invert();
     * inv.transformDirection(dir.set(1, 0, 0)).normalize();
     * </pre>
     * If <code>this</code> is already an orthogonal matrix, then consider using {@link #normalizedPositiveX(Vector3d)} instead.
     * <p>
     * Reference: <a href="http://www.euclideanspace.com/maths/algebra/matrix/functions/inverse/threeD/">http://www.euclideanspace.com</a>
     * 
     * @param dir
     *          will hold the direction of <tt>+X</tt>
     * @return dir
     */
    Vector3d positiveX(Vector3d dir);

    /**
     * Obtain the direction of <tt>+X</tt> before the transformation represented by <code>this</code> <i>orthogonal</i> matrix is applied.
     * This method only produces correct results if <code>this</code> is an <i>orthogonal</i> matrix.
     * <p>
     * This method uses the rotation component of the left 3x3 submatrix to obtain the direction 
     * that is transformed to <tt>+X</tt> by <code>this</code> matrix.
     * <p>
     * This method is equivalent to the following code:
     * <pre>
     * Matrix4x3d inv = new Matrix4x3d(this).transpose();
     * inv.transformDirection(dir.set(1, 0, 0)).normalize();
     * </pre>
     * <p>
     * Reference: <a href="http://www.euclideanspace.com/maths/algebra/matrix/functions/inverse/threeD/">http://www.euclideanspace.com</a>
     * 
     * @param dir
     *          will hold the direction of <tt>+X</tt>
     * @return dir
     */
    Vector3d normalizedPositiveX(Vector3d dir);

    /**
     * Obtain the direction of <tt>+Y</tt> before the transformation represented by <code>this</code> matrix is applied.
     * <p>
     * This method uses the rotation component of the left 3x3 submatrix to obtain the direction 
     * that is transformed to <tt>+Y</tt> by <code>this</code> matrix.
     * <p>
     * This method is equivalent to the following code:
     * <pre>
     * Matrix4x3d inv = new Matrix4x3d(this).invert();
     * inv.transformDirection(dir.set(0, 1, 0)).normalize();
     * </pre>
     * If <code>this</code> is already an orthogonal matrix, then consider using {@link #normalizedPositiveY(Vector3d)} instead.
     * <p>
     * Reference: <a href="http://www.euclideanspace.com/maths/algebra/matrix/functions/inverse/threeD/">http://www.euclideanspace.com</a>
     * 
     * @param dir
     *          will hold the direction of <tt>+Y</tt>
     * @return dir
     */
    Vector3d positiveY(Vector3d dir);

    /**
     * Obtain the direction of <tt>+Y</tt> before the transformation represented by <code>this</code> <i>orthogonal</i> matrix is applied.
     * This method only produces correct results if <code>this</code> is an <i>orthogonal</i> matrix.
     * <p>
     * This method uses the rotation component of the left 3x3 submatrix to obtain the direction 
     * that is transformed to <tt>+Y</tt> by <code>this</code> matrix.
     * <p>
     * This method is equivalent to the following code:
     * <pre>
     * Matrix4x3d inv = new Matrix4x3d(this).transpose();
     * inv.transformDirection(dir.set(0, 1, 0)).normalize();
     * </pre>
     * <p>
     * Reference: <a href="http://www.euclideanspace.com/maths/algebra/matrix/functions/inverse/threeD/">http://www.euclideanspace.com</a>
     * 
     * @param dir
     *          will hold the direction of <tt>+Y</tt>
     * @return dir
     */
    Vector3d normalizedPositiveY(Vector3d dir);

    /**
     * Obtain the position that gets transformed to the origin by <code>this</code> matrix.
     * This can be used to get the position of the "camera" from a given <i>view</i> transformation matrix.
     * <p>
     * This method is equivalent to the following code:
     * <pre>
     * Matrix4x3f inv = new Matrix4x3f(this).invert();
     * inv.transformPosition(origin.set(0, 0, 0));
     * </pre>
     * 
     * @param origin
     *          will hold the position transformed to the origin
     * @return origin
     */
    Vector3d origin(Vector3d origin);

    /**
     * Apply a projection transformation to this matrix that projects onto the plane specified via the general plane equation
     * <tt>x*a + y*b + z*c + d = 0</tt> as if casting a shadow from a given light position/direction <code>light</code>
     * and store the result in <code>dest</code>.
     * <p>
     * If <tt>light.w</tt> is <tt>0.0</tt> the light is being treated as a directional light; if it is <tt>1.0</tt> it is a point light.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the shadow matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>, the
     * reflection will be applied first!
     * <p>
     * Reference: <a href="ftp://ftp.sgi.com/opengl/contrib/blythe/advanced99/notes/node192.html">ftp.sgi.com</a>
     * 
     * @param light
     *          the light's vector
     * @param a
     *          the x factor in the plane equation
     * @param b
     *          the y factor in the plane equation
     * @param c
     *          the z factor in the plane equation
     * @param d
     *          the constant in the plane equation
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d shadow(Vector4dc light, double a, double b, double c, double d, Matrix4x3d dest);

    /**
     * Apply a projection transformation to this matrix that projects onto the plane specified via the general plane equation
     * <tt>x*a + y*b + z*c + d = 0</tt> as if casting a shadow from a given light position/direction <tt>(lightX, lightY, lightZ, lightW)</tt>
     * and store the result in <code>dest</code>.
     * <p>
     * If <code>lightW</code> is <tt>0.0</tt> the light is being treated as a directional light; if it is <tt>1.0</tt> it is a point light.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the shadow matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>, the
     * reflection will be applied first!
     * <p>
     * Reference: <a href="ftp://ftp.sgi.com/opengl/contrib/blythe/advanced99/notes/node192.html">ftp.sgi.com</a>
     * 
     * @param lightX
     *          the x-component of the light's vector
     * @param lightY
     *          the y-component of the light's vector
     * @param lightZ
     *          the z-component of the light's vector
     * @param lightW
     *          the w-component of the light's vector
     * @param a
     *          the x factor in the plane equation
     * @param b
     *          the y factor in the plane equation
     * @param c
     *          the z factor in the plane equation
     * @param d
     *          the constant in the plane equation
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d shadow(double lightX, double lightY, double lightZ, double lightW, double a, double b, double c, double d, Matrix4x3d dest);

    /**
     * Apply a projection transformation to this matrix that projects onto the plane with the general plane equation
     * <tt>y = 0</tt> as if casting a shadow from a given light position/direction <code>light</code>
     * and store the result in <code>dest</code>.
     * <p>
     * Before the shadow projection is applied, the plane is transformed via the specified <code>planeTransformation</code>.
     * <p>
     * If <tt>light.w</tt> is <tt>0.0</tt> the light is being treated as a directional light; if it is <tt>1.0</tt> it is a point light.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the shadow matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>, the
     * reflection will be applied first!
     * 
     * @param light
     *          the light's vector
     * @param planeTransform
     *          the transformation to transform the implied plane <tt>y = 0</tt> before applying the projection
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d shadow(Vector4dc light, Matrix4x3dc planeTransform, Matrix4x3d dest);

    /**
     * Apply a projection transformation to this matrix that projects onto the plane with the general plane equation
     * <tt>y = 0</tt> as if casting a shadow from a given light position/direction <tt>(lightX, lightY, lightZ, lightW)</tt>
     * and store the result in <code>dest</code>.
     * <p>
     * Before the shadow projection is applied, the plane is transformed via the specified <code>planeTransformation</code>.
     * <p>
     * If <code>lightW</code> is <tt>0.0</tt> the light is being treated as a directional light; if it is <tt>1.0</tt> it is a point light.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the shadow matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>, the
     * reflection will be applied first!
     * 
     * @param lightX
     *          the x-component of the light vector
     * @param lightY
     *          the y-component of the light vector
     * @param lightZ
     *          the z-component of the light vector
     * @param lightW
     *          the w-component of the light vector
     * @param planeTransform
     *          the transformation to transform the implied plane <tt>y = 0</tt> before applying the projection
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d shadow(double lightX, double lightY, double lightZ, double lightW, Matrix4x3dc planeTransform, Matrix4x3d dest);

    /**
     * Apply a picking transformation to this matrix using the given window coordinates <tt>(x, y)</tt> as the pick center
     * and the given <tt>(width, height)</tt> as the size of the picking region in window coordinates, and store the result
     * in <code>dest</code>.
     * 
     * @param x
     *          the x coordinate of the picking region center in window coordinates
     * @param y
     *          the y coordinate of the picking region center in window coordinates
     * @param width
     *          the width of the picking region in window coordinates
     * @param height
     *          the height of the picking region in window coordinates
     * @param viewport
     *          the viewport described by <tt>[x, y, width, height]</tt>
     * @param dest
     *          the destination matrix, which will hold the result
     * @return dest
     */
    Matrix4x3d pick(double x, double y, double width, double height, int[] viewport, Matrix4x3d dest);

    /**
     * Apply an arcball view transformation to this matrix with the given <code>radius</code> and center <tt>(centerX, centerY, centerZ)</tt>
     * position of the arcball and the specified X and Y rotation angles, and store the result in <code>dest</code>.
     * <p>
     * This method is equivalent to calling: <tt>translate(0, 0, -radius).rotateX(angleX).rotateY(angleY).translate(-centerX, -centerY, -centerZ)</tt>
     * 
     * @param radius
     *          the arcball radius
     * @param centerX
     *          the x coordinate of the center position of the arcball
     * @param centerY
     *          the y coordinate of the center position of the arcball
     * @param centerZ
     *          the z coordinate of the center position of the arcball
     * @param angleX
     *          the rotation angle around the X axis in radians
     * @param angleY
     *          the rotation angle around the Y axis in radians
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d arcball(double radius, double centerX, double centerY, double centerZ, double angleX, double angleY, Matrix4x3d dest);

    /**
     * Apply an arcball view transformation to this matrix with the given <code>radius</code> and <code>center</code>
     * position of the arcball and the specified X and Y rotation angles, and store the result in <code>dest</code>.
     * <p>
     * This method is equivalent to calling: <tt>translate(0, 0, -radius).rotateX(angleX).rotateY(angleY).translate(-center.x, -center.y, -center.z)</tt>
     * 
     * @param radius
     *          the arcball radius
     * @param center
     *          the center position of the arcball
     * @param angleX
     *          the rotation angle around the X axis in radians
     * @param angleY
     *          the rotation angle around the Y axis in radians
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d arcball(double radius, Vector3dc center, double angleX, double angleY, Matrix4x3d dest);

    /**
     * Transform the axis-aligned box given as the minimum corner <tt>(minX, minY, minZ)</tt> and maximum corner <tt>(maxX, maxY, maxZ)</tt>
     * by <code>this</code> matrix and compute the axis-aligned box of the result whose minimum corner is stored in <code>outMin</code>
     * and maximum corner stored in <code>outMax</code>.
     * <p>
     * Reference: <a href="http://dev.theomader.com/transform-bounding-boxes/">http://dev.theomader.com</a>
     * 
     * @param minX
     *              the x coordinate of the minimum corner of the axis-aligned box
     * @param minY
     *              the y coordinate of the minimum corner of the axis-aligned box
     * @param minZ
     *              the z coordinate of the minimum corner of the axis-aligned box
     * @param maxX
     *              the x coordinate of the maximum corner of the axis-aligned box
     * @param maxY
     *              the y coordinate of the maximum corner of the axis-aligned box
     * @param maxZ
     *              the y coordinate of the maximum corner of the axis-aligned box
     * @param outMin
     *              will hold the minimum corner of the resulting axis-aligned box
     * @param outMax
     *              will hold the maximum corner of the resulting axis-aligned box
     * @return this
     */
    Matrix4x3d transformAab(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, Vector3d outMin, Vector3d outMax);

    /**
     * Transform the axis-aligned box given as the minimum corner <code>min</code> and maximum corner <code>max</code>
     * by <code>this</code> matrix and compute the axis-aligned box of the result whose minimum corner is stored in <code>outMin</code>
     * and maximum corner stored in <code>outMax</code>.
     * 
     * @param min
     *              the minimum corner of the axis-aligned box
     * @param max
     *              the maximum corner of the axis-aligned box
     * @param outMin
     *              will hold the minimum corner of the resulting axis-aligned box
     * @param outMax
     *              will hold the maximum corner of the resulting axis-aligned box
     * @return this
     */
    Matrix4x3d transformAab(Vector3dc min, Vector3dc max, Vector3d outMin, Vector3d outMax);

    /**
     * Linearly interpolate <code>this</code> and <code>other</code> using the given interpolation factor <code>t</code>
     * and store the result in <code>dest</code>.
     * <p>
     * If <code>t</code> is <tt>0.0</tt> then the result is <code>this</code>. If the interpolation factor is <code>1.0</code>
     * then the result is <code>other</code>.
     *
     * @param other
     *          the other matrix
     * @param t
     *          the interpolation factor between 0.0 and 1.0
     * @param dest
     *          will hold the result
     * @return dest
     */
    Matrix4x3d lerp(Matrix4x3dc other, double t, Matrix4x3d dest);

    /**
     * Apply a model transformation to this matrix for a right-handed coordinate system, 
     * that aligns the <code>-z</code> axis with <code>dir</code>
     * and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>L</code> the lookat matrix,
     * then the new matrix will be <code>M * L</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * L * v</code>,
     * the lookat transformation will be applied first!
     * <p>
     * This method is equivalent to calling: <tt>mul(new Matrix4x3d().lookAt(new Vector3d(), new Vector3d(dir).negate(), up).invert(), dest)</tt>
     * 
     * @see #rotateTowards(double, double, double, double, double, double, Matrix4x3d)
     * 
     * @param dir
     *              the direction to rotate towards
     * @param up
     *              the up vector
     * @param dest
     *              will hold the result
     * @return dest
     */
    Matrix4x3d rotateTowards(Vector3dc dir, Vector3dc up, Matrix4x3d dest);

    /**
     * Apply a model transformation to this matrix for a right-handed coordinate system, 
     * that aligns the <code>-z</code> axis with <code>(dirX, dirY, dirZ)</code>
     * and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>L</code> the lookat matrix,
     * then the new matrix will be <code>M * L</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * L * v</code>,
     * the lookat transformation will be applied first!
     * <p>
     * This method is equivalent to calling: <tt>mul(new Matrix4x3d().lookAt(0, 0, 0, -dirX, -dirY, -dirZ, upX, upY, upZ).invert(), dest)</tt>
     * 
     * @see #rotateTowards(Vector3dc, Vector3dc, Matrix4x3d)
     * 
     * @param dirX
     *              the x-coordinate of the direction to rotate towards
     * @param dirY
     *              the y-coordinate of the direction to rotate towards
     * @param dirZ
     *              the z-coordinate of the direction to rotate towards
     * @param upX
     *              the x-coordinate of the up vector
     * @param upY
     *              the y-coordinate of the up vector
     * @param upZ
     *              the z-coordinate of the up vector
     * @param dest
     *              will hold the result
     * @return dest
     */
    Matrix4x3d rotateTowards(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, Matrix4x3d dest);

    /**
     * Extract the Euler angles from the rotation represented by the upper left 3x3 submatrix of <code>this</code>
     * and store the extracted Euler angles in <code>dest</code>.
     * <p>
     * This method assumes that the upper left of <code>this</code> only represents a rotation without scaling.
     * <p>
     * Note that the returned Euler angles must be applied in the order <tt>Z * Y * X</tt> to obtain the identical matrix.
     * This means that calling {@link Matrix4x3d#rotateZYX(double, double, double)} using the obtained Euler angles will yield
     * the same rotation as the original matrix from which the Euler angles were obtained, so in the below code the matrix
     * <tt>m2</tt> should be identical to <tt>m</tt> (disregarding possible floating-point inaccuracies).
     * <pre>
     * Matrix4x3d m = ...; // &lt;- matrix only representing rotation
     * Matrix4x3d n = new Matrix4x3d();
     * n.rotateZYX(m.getEulerAnglesZYX(new Vector3d()));
     * </pre>
     * <p>
     * Reference: <a href="http://nghiaho.com/?page_id=846">http://nghiaho.com/</a>
     * 
     * @param dest
     *          will hold the extracted Euler angles
     * @return dest
     */
    Vector3d getEulerAnglesZYX(Vector3d dest);

}