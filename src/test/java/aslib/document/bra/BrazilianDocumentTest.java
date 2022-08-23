package aslib.document.bra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * <p style="text-align:justify">
 * Tests for the {@link BrazilianDocument} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class BrazilianDocumentTest {

    private final BrazilianDocument document = new BrazilianDocument();


    @Test
    @DisplayName("CNPJ: Returns instance of 'CNPJ' when successful")
    void cnpj() {
        assertInstanceOf(CNPJ.class, document.cnpj());
    }

    @Test
    @DisplayName("CPF: Returns instance of 'CPF' when successful")
    void cpf() {
        assertInstanceOf(CPF.class, document.cpf());
    }

    @Test
    @DisplayName("PIS: Returns instance of 'PIS' when successful")
    void pis() {
        assertInstanceOf(PIS.class, document.pis());
    }

    @Test
    @DisplayName("RG: Returns instance of 'RG' when successful")
    void rg() {
        assertInstanceOf(RG.class, document.rg());
    }

    @Test
    @DisplayName("VoterTitle: Returns instance of 'VoterTitle' when successful")
    void voterTitle() {
        assertInstanceOf(VoterTitle.class, document.voterTitle());
    }
}
