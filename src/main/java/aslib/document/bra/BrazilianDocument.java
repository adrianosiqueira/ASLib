package aslib.document.bra;

import aslib.document.DocumentCoreUtil;

/**
 * <p style="text-align:justify">
 * Entry point for the Brazilian implementation of the API.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public final class BrazilianDocument {

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link BrazilianDocument} class. Such instance is
     * necessary to get the instance of the brazilian document implementations.
     * </p>
     *
     * @since 1.0.0
     */
    public BrazilianDocument() {}


    /**
     * <p style="text-align:justify">
     * Access the implementation of {@link CNPJ}.
     * </p>
     *
     * @return The CNPJ implementation.
     *
     * @since 1.0.0
     */
    public DocumentCoreUtil cnpj() {
        return new CNPJ();
    }

    /**
     * <p style="text-align:justify">
     * Access the implementation of {@link CPF}.
     * </p>
     *
     * @return The CPF implementation.
     *
     * @since 1.0.0
     */
    public DocumentCoreUtil cpf() {
        return new CPF();
    }

    /**
     * <p style="text-align:justify">
     * Access the implementation of {@link PIS}.
     * </p>
     *
     * @return The PIS implementation.
     *
     * @since 1.0.0
     */
    public DocumentCoreUtil pis() {
        return new PIS();
    }

    /**
     * <p style="text-align:justify">
     * Access the implementation of {@link RG}.
     * </p>
     *
     * @return The RG implementation.
     *
     * @since 1.0.0
     */
    public DocumentCoreUtil rg() {
        return new RG();
    }

    /**
     * <p style="text-align:justify">
     * Access the implementation of {@link VoterTitle}.
     * </p>
     *
     * @return The VoterTitle implementation.
     *
     * @since 1.0.0
     */
    public DocumentCoreUtil voterTitle() {
        return new VoterTitle();
    }
}
