package lu.embellishedduck.engine.physics.geometry.vector;

/**
 * Contains all the functions pertaining to the implementations of {@code AbstractVector3D}, most results are returned as
 * an instance of {@code AbstractVector3D} which allows for polymorphism through type casting.
 * Additionally, a combination of both Dynamic and Static vectors can be used in the calculations.
 *
 * @since 1.0.0
 *
 * @author Will Blanchard
 */
public class VectorMath {

    /**
     * Adds two vectors together, is commutative (A+B = B+A)
     *
     * @param A A vector
     * @param B Another vector
     * @return The sum of the two vectors
     */
    public static AbstractVector3D add(AbstractVector3D A, AbstractVector3D B) {

        return new AbstractVector3D() {
            @Override
            public double getX() {return A.getX() + B.getX();}
            @Override
            public double getY() {return A.getY() + B.getY();}
            @Override
            public double getZ() {return A.getZ() + B.getZ();}
        };//End of Anonymous Instantiation

    }//End of Method


    /**
     * Subtracts one vector from another, is a non-commutative operation (AB != BA)
     *
     * @param A The current vector
     * @param B The target vector
     * @return The vector AB
     */
    public static AbstractVector3D subtract(AbstractVector3D A, AbstractVector3D B) {

        return new AbstractVector3D() {
            @Override
            public double getX() {return B.getX() - A.getX();}
            @Override
            public double getY() {return B.getY() - A.getY();}
            @Override
            public double getZ() {return B.getZ() - A.getZ();}

        };//End of Anonymous Instantiation

    }//End of Method


    /**
     * Multiplies two vectors together, is commutative.
     *
     * @param A A vector
     * @param B Another vector
     * @return The product of the two vectors
     */
    public static AbstractVector3D multiply(AbstractVector3D A, AbstractVector3D B) {

        return new AbstractVector3D() {
            @Override
            public double getX() {return A.getX() * B.getX();}
            @Override
            public double getY() {return A.getY() * B.getY();}
            @Override
            public double getZ() {return A.getZ() * B.getZ();}

        };//End of Anonymous Instantiation

    }//End of Method


    /**
     * Divides one vector from another, is not commutative
     *
     * @param A A vector
     * @param B Another vector
     * @return The dividend of A / B
     */
    public static AbstractVector3D divide(AbstractVector3D A, AbstractVector3D B) {

        return new AbstractVector3D() {
            @Override
            public double getX() {return A.getX() / B.getX();}
            @Override
            public double getY() {return A.getY() * B.getY();}
            @Override
            public double getZ() {return A.getZ() / B.getZ();}

        };//End of Anonymous Instantiation

    }//End of Method


    /**
     * Method overload for a numeric vector division (Vector / number)
     *
     * @param A A vector
     * @param B A number
     * @return The dividend vector
     */
    public static AbstractVector3D divide(AbstractVector3D A, double B) {

        return new AbstractVector3D() {
            @Override
            public double getX() {return A.getX() / B;}
            @Override
            public double getY() {return A.getY() / B;}
            @Override
            public double getZ() {return A.getZ() / B;}

        };//End of Anonymous Method

    }//End of Method


    /**
     * Calculates the magnitude of a vector and returns it as a double
     *
     * @param vector A vector
     * @return The magnitude (length) of the vector.
     */
    public static double magnitude(AbstractVector3D vector) {

        return Math.sqrt((vector.getX() * vector.getX()) + (vector.getY() * vector.getY()) + (vector.getZ() * vector.getZ()));

    }//End of Method


    /**
     * A float override for {@code magnitude()}, returns the result as a float
     *
     * @param vector A vector
     * @return The magnitude
     */
    public static float magnitudeFloat(AbstractVector3D vector) {

        return (float) Math.sqrt((vector.getX() * vector.getX()) + (vector.getY() * vector.getY()) + (vector.getZ() * vector.getZ()));

    }//End of Method


    /**
     * Finds the direction of a vector, which is also known as it's normal
     *
     * @param vector A vector
     * @return The direction of the vector
     */
    public static AbstractVector3D normalize(AbstractVector3D vector) {

        return divide(vector, magnitude(vector));

    }//End of Method


    /**
     * Finds the velocity vector using the direction of travel.
     *
     * @param vector A normalized vector
     * @param speed A scalar value
     * @return The velocity vector
     */
    public static AbstractVector3D velocity(AbstractVector3D vector, double speed) {

        return new AbstractVector3D() {
            @Override
            public double getX() {return vector.getX() * speed;}
            @Override
            public double getY() {return vector.getY() * speed;}
            @Override
            public double getZ() {return vector.getZ() * speed;}

        };//End of Anonymous Instantiation

    }//End of Method


    /**
     * Finds the velocity vector while calculating the direction of travel.
     *
     * @param vector A non-normalized vector
     * @param speed A scalar value
     * @return The velocity vector
     */
    public static AbstractVector3D normalizeVelocity(AbstractVector3D vector, double speed) {

        AbstractVector3D normalized = normalize(vector);
        return new AbstractVector3D() {
            @Override
            public double getX() {return normalized.getX() * speed;}
            @Override
            public double getY() {return normalized.getY() * speed;}
            @Override
            public double getZ() {return normalized.getZ() * speed;}

        };//End of Anonymous Instantiation

    }//End of Method


    /**
     * Finds the dot product of two vectors, returns the resulting angle in radians
     *
     * @param A A position vector
     * @param B Another position vector
     * @return The angle in radians as a double
     */
    public static double dotProduct(AbstractVector3D A, AbstractVector3D B) {

        return Math.acos(((A.getX() * B.getX()) + (A.getY() * B.getY()) + (A.getZ() * B.getZ())) / (magnitude(A) * magnitude(B)));

    }//End of Method


    /**
     * Finds the vector which is perpendicular (orthogonally) to both A and B
     *
     * @param A A position vector
     * @param B Another position vector
     * @return The vector perpendicular to {@code A} and {@code B}
     */
    public static AbstractVector3D crossProduct(AbstractVector3D A, AbstractVector3D B) {

        return new AbstractVector3D() {
            @Override
            public double getX() {return (A.getY() * B.getZ()) - (A.getZ() * B.getY());}
            @Override
            public double getY() {return (A.getZ() * B.getX()) - (A.getX() * B.getY());}
            @Override
            public double getZ() {return (A.getX() * B.getY()) - (B.getY() * A.getX());}
        };

    }//End of Method

}//End of Class