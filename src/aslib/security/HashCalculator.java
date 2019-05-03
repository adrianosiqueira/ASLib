package aslib.security;

import aslib.exceptions.ExecutionNotDoneException;

/**
 * <p> Flag interface to indicate that some class is an implementation of a hash calculator. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public interface HashCalculator {
    /**
     * @return The calculated hash.
     * @throws ExecutionNotDoneException If this method is call before the calculation is finished.
     */
    String getHash() throws ExecutionNotDoneException;
}
