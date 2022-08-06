package aslib.ai.genderdetector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link GenderDetector} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
@SuppressWarnings("SpellCheckingInspection")
class GenderDetectorTest {

    private final GenderDetector detector = new GenderDetector();

    @Test
    @DisplayName("Detect: Throws 'NullPointerException' when name is null")
    void detect_001() {
        assertThrows(NullPointerException.class, () -> detector.detect(null));
    }

    @Test
    @DisplayName("Detect: Returns 'UNDEFINED' when name has less than three letters")
    void detect_002() {
        assertEquals(Gender.UNDEFINED, detector.detect("a"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Anaderge'")
    void detect_003() {
        assertEquals(Gender.FEMININE, detector.detect("Anaderge"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Ariel'")
    void detect_004() {
        assertEquals(Gender.FEMININE, detector.detect("Ariel"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Bete'")
    void detect_005() {
        assertEquals(Gender.FEMININE, detector.detect("Bete"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Cauana'")
    void detect_006() {
        assertEquals(Gender.FEMININE, detector.detect("Cauana"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Chaissen'")
    void detect_007() {
        assertEquals(Gender.FEMININE, detector.detect("Chaissen"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Conceição'")
    void detect_008() {
        assertEquals(Gender.FEMININE, detector.detect("Conceição"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Dani'")
    void detect_009() {
        assertEquals(Gender.FEMININE, detector.detect("Dani"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Danieli'")
    void detect_010() {
        assertEquals(Gender.FEMININE, detector.detect("Danieli"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Elen'")
    void detect_011() {
        assertEquals(Gender.FEMININE, detector.detect("Elen"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Eleonor'")
    void detect_012() {
        assertEquals(Gender.FEMININE, detector.detect("Eleonor"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Elienai'")
    void detect_013() {
        assertEquals(Gender.FEMININE, detector.detect("Elienai"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Ester'")
    void detect_014() {
        assertEquals(Gender.FEMININE, detector.detect("Ester"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Gisele'")
    void detect_015() {
        assertEquals(Gender.FEMININE, detector.detect("Gisele"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Iasmin'")
    void detect_016() {
        assertEquals(Gender.FEMININE, detector.detect("Iasmin"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Iolanda'")
    void detect_017() {
        assertEquals(Gender.FEMININE, detector.detect("Iolanda"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Iris'")
    void detect_018() {
        assertEquals(Gender.FEMININE, detector.detect("Íris"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Isabel'")
    void detect_019() {
        assertEquals(Gender.FEMININE, detector.detect("Isabel"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Isabeli'")
    void detect_020() {
        assertEquals(Gender.FEMININE, detector.detect("Isabeli"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Jasmin'")
    void detect_021() {
        assertEquals(Gender.FEMININE, detector.detect("Jasmin"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Katy'")
    void detect_022() {
        assertEquals(Gender.FEMININE, detector.detect("Katy"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Lilian'")
    void detect_023() {
        assertEquals(Gender.FEMININE, detector.detect("Lilian"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Luane'")
    void detect_024() {
        assertEquals(Gender.FEMININE, detector.detect("Luane"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Luani'")
    void detect_025() {
        assertEquals(Gender.FEMININE, detector.detect("Luani"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Luise'")
    void detect_026() {
        assertEquals(Gender.FEMININE, detector.detect("Luíse"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Luize'")
    void detect_027() {
        assertEquals(Gender.FEMININE, detector.detect("Luíze"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Mabel'")
    void detect_028() {
        assertEquals(Gender.FEMININE, detector.detect("Mabel"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Marlene'")
    void detect_029() {
        assertEquals(Gender.FEMININE, detector.detect("Marlene"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Miria'")
    void detect_030() {
        assertEquals(Gender.FEMININE, detector.detect("Miriã"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Mirian'")
    void detect_031() {
        assertEquals(Gender.FEMININE, detector.detect("Mirian"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Muriel'")
    void detect_032() {
        assertEquals(Gender.FEMININE, detector.detect("Muriel"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Nadir'")
    void detect_033() {
        assertEquals(Gender.FEMININE, detector.detect("Nadir"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Raquel'")
    void detect_034() {
        assertEquals(Gender.FEMININE, detector.detect("Raquel"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Reencarnação'")
    void detect_035() {
        assertEquals(Gender.FEMININE, detector.detect("Reencarnação"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Ressurreição'")
    void detect_036() {
        assertEquals(Gender.FEMININE, detector.detect("Ressurreição"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Riane'")
    void detect_037() {
        assertEquals(Gender.FEMININE, detector.detect("Riane"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Riani'")
    void detect_038() {
        assertEquals(Gender.FEMININE, detector.detect("Riani"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Rute'")
    void detect_039() {
        assertEquals(Gender.FEMININE, detector.detect("Rute"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Sarah'")
    void detect_040() {
        assertEquals(Gender.FEMININE, detector.detect("Sarah"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Sueli'")
    void detect_041() {
        assertEquals(Gender.FEMININE, detector.detect("Sueli"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Tais'")
    void detect_042() {
        assertEquals(Gender.FEMININE, detector.detect("Taís"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Taise'")
    void detect_043() {
        assertEquals(Gender.FEMININE, detector.detect("Taise"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Taisi'")
    void detect_044() {
        assertEquals(Gender.FEMININE, detector.detect("Taisi"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Taize'")
    void detect_045() {
        assertEquals(Gender.FEMININE, detector.detect("Taize"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Tami'")
    void detect_046() {
        assertEquals(Gender.FEMININE, detector.detect("Tami"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Tauana'")
    void detect_047() {
        assertEquals(Gender.FEMININE, detector.detect("Tauana"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Tauane'")
    void detect_048() {
        assertEquals(Gender.FEMININE, detector.detect("Tauane"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Thainá'")
    void detect_049() {
        assertEquals(Gender.FEMININE, detector.detect("Thainá"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Wendi'")
    void detect_050() {
        assertEquals(Gender.FEMININE, detector.detect("Wendi"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Adrian'")
    void detect_051() {
        assertEquals(Gender.MASCULINE, detector.detect("Adrian"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Adrien'")
    void detect_052() {
        assertEquals(Gender.MASCULINE, detector.detect("Adrien"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Alaf'")
    void detect_053() {
        assertEquals(Gender.MASCULINE, detector.detect("Alaf"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Alexandre'")
    void detect_054() {
        assertEquals(Gender.MASCULINE, detector.detect("Alexandre"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Alisson'")
    void detect_055() {
        assertEquals(Gender.MASCULINE, detector.detect("Alisson"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Andrade'")
    void detect_056() {
        assertEquals(Gender.MASCULINE, detector.detect("Andrade"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Benjamin'")
    void detect_057() {
        assertEquals(Gender.MASCULINE, detector.detect("Benjamin"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Carlos'")
    void detect_058() {
        assertEquals(Gender.MASCULINE, detector.detect("Carlos"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Carter'")
    void detect_059() {
        assertEquals(Gender.MASCULINE, detector.detect("Carter"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Castiel'")
    void detect_060() {
        assertEquals(Gender.MASCULINE, detector.detect("Castiel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Cauã'")
    void detect_061() {
        assertEquals(Gender.MASCULINE, detector.detect("Cauã"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Claudionor'")
    void detect_062() {
        assertEquals(Gender.MASCULINE, detector.detect("Claudionor"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Cristofer'")
    void detect_063() {
        assertEquals(Gender.MASCULINE, detector.detect("Cristofer"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Daniel'")
    void detect_064() {
        assertEquals(Gender.MASCULINE, detector.detect("Daniel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Dante'")
    void detect_065() {
        assertEquals(Gender.MASCULINE, detector.detect("Dante"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Davi'")
    void detect_066() {
        assertEquals(Gender.MASCULINE, detector.detect("Davi"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'David'")
    void detect_067() {
        assertEquals(Gender.MASCULINE, detector.detect("David"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Deivede'")
    void detect_068() {
        assertEquals(Gender.MASCULINE, detector.detect("Deivede"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Doni'")
    void detect_069() {
        assertEquals(Gender.MASCULINE, detector.detect("Doni"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Eitor'")
    void detect_070() {
        assertEquals(Gender.MASCULINE, detector.detect("Eitor"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Elias'")
    void detect_071() {
        assertEquals(Gender.MASCULINE, detector.detect("Elias"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Eliesel'")
    void detect_072() {
        assertEquals(Gender.MASCULINE, detector.detect("Eliesel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Eliot'")
    void detect_073() {
        assertEquals(Gender.MASCULINE, detector.detect("Eliot"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Felipe'")
    void detect_074() {
        assertEquals(Gender.MASCULINE, detector.detect("Felipe"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Felipi'")
    void detect_075() {
        assertEquals(Gender.MASCULINE, detector.detect("Felipi"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Fredi'")
    void detect_076() {
        assertEquals(Gender.MASCULINE, detector.detect("Fredi"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Gesiel'")
    void detect_077() {
        assertEquals(Gender.MASCULINE, detector.detect("Gesiel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Guilherme'")
    void detect_078() {
        assertEquals(Gender.MASCULINE, detector.detect("Guilherme"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Henrique'")
    void detect_079() {
        assertEquals(Gender.MASCULINE, detector.detect("Henrique"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Isac'")
    void detect_080() {
        assertEquals(Gender.MASCULINE, detector.detect("Isac"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Isak'")
    void detect_081() {
        assertEquals(Gender.MASCULINE, detector.detect("Isak"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Isaque'")
    void detect_082() {
        assertEquals(Gender.MASCULINE, detector.detect("Isaque"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Iuri'")
    void detect_083() {
        assertEquals(Gender.MASCULINE, detector.detect("Iuri"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Jacir'")
    void detect_084() {
        assertEquals(Gender.MASCULINE, detector.detect("Jacir"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Jack'")
    void detect_085() {
        assertEquals(Gender.MASCULINE, detector.detect("Jack"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Jackie'")
    void detect_086() {
        assertEquals(Gender.MASCULINE, detector.detect("Jackie"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Jacó'")
    void detect_087() {
        assertEquals(Gender.MASCULINE, detector.detect("Jacó"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Jair'")
    void detect_088() {
        assertEquals(Gender.MASCULINE, detector.detect("Jair"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Jesiel'")
    void detect_089() {
        assertEquals(Gender.MASCULINE, detector.detect("Jesiel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Jesus'")
    void detect_090() {
        assertEquals(Gender.MASCULINE, detector.detect("Jesus"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'João'")
    void detect_091() {
        assertEquals(Gender.MASCULINE, detector.detect("João"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Joaquin'")
    void detect_092() {
        assertEquals(Gender.MASCULINE, detector.detect("Joaquin"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'José'")
    void detect_093() {
        assertEquals(Gender.MASCULINE, detector.detect("José"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Juca'")
    void detect_094() {
        assertEquals(Gender.MASCULINE, detector.detect("Juca"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Kenedi'")
    void detect_095() {
        assertEquals(Gender.MASCULINE, detector.detect("Kenedi"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Leonel'")
    void detect_096() {
        assertEquals(Gender.MASCULINE, detector.detect("Leonel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Luan'")
    void detect_097() {
        assertEquals(Gender.MASCULINE, detector.detect("Luan"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Luca'")
    void detect_098() {
        assertEquals(Gender.MASCULINE, detector.detect("Luca"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Lucas'")
    void detect_099() {
        assertEquals(Gender.MASCULINE, detector.detect("Lucas"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Luis'")
    void detect_100() {
        assertEquals(Gender.MASCULINE, detector.detect("Luis"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Manoel'")
    void detect_101() {
        assertEquals(Gender.MASCULINE, detector.detect("Manoel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Manuel'")
    void detect_102() {
        assertEquals(Gender.MASCULINE, detector.detect("Manuel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Marcel'")
    void detect_103() {
        assertEquals(Gender.MASCULINE, detector.detect("Marcel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Marlon'")
    void detect_104() {
        assertEquals(Gender.MASCULINE, detector.detect("Marlon"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Mateus'")
    void detect_105() {
        assertEquals(Gender.MASCULINE, detector.detect("Mateus"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Matheus'")
    void detect_106() {
        assertEquals(Gender.MASCULINE, detector.detect("Matheus"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Maxuel'")
    void detect_107() {
        assertEquals(Gender.MASCULINE, detector.detect("Maxuel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Michael'")
    void detect_108() {
        assertEquals(Gender.MASCULINE, detector.detect("Michael"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Michel'")
    void detect_109() {
        assertEquals(Gender.MASCULINE, detector.detect("Michel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Philip'")
    void detect_110() {
        assertEquals(Gender.MASCULINE, detector.detect("Philip"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Philipe'")
    void detect_111() {
        assertEquals(Gender.MASCULINE, detector.detect("Philipe"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Philipi'")
    void detect_112() {
        assertEquals(Gender.MASCULINE, detector.detect("Philipi"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Rafael'")
    void detect_113() {
        assertEquals(Gender.MASCULINE, detector.detect("Rafael"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Raoni'")
    void detect_114() {
        assertEquals(Gender.MASCULINE, detector.detect("Raoni"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Raul'")
    void detect_115() {
        assertEquals(Gender.MASCULINE, detector.detect("Raul"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Ravi'")
    void detect_116() {
        assertEquals(Gender.MASCULINE, detector.detect("Ravi"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Rex'")
    void detect_117() {
        assertEquals(Gender.MASCULINE, detector.detect("Rex"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Rian'")
    void detect_118() {
        assertEquals(Gender.MASCULINE, detector.detect("Rian"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Riquelme'")
    void detect_119() {
        assertEquals(Gender.MASCULINE, detector.detect("Riquelme"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Ruan'")
    void detect_120() {
        assertEquals(Gender.MASCULINE, detector.detect("Ruan"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Samuel'")
    void detect_121() {
        assertEquals(Gender.MASCULINE, detector.detect("Samuel"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Sartor'")
    void detect_122() {
        assertEquals(Gender.MASCULINE, detector.detect("Sartor"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Saul'")
    void detect_123() {
        assertEquals(Gender.MASCULINE, detector.detect("Saul"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Serafin'")
    void detect_124() {
        assertEquals(Gender.MASCULINE, detector.detect("Serafin"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Sidnei'")
    void detect_125() {
        assertEquals(Gender.MASCULINE, detector.detect("Sidnei"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Tales'")
    void detect_126() {
        assertEquals(Gender.MASCULINE, detector.detect("Tales"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Tomi'")
    void detect_127() {
        assertEquals(Gender.MASCULINE, detector.detect("Tomi"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Toni'")
    void detect_128() {
        assertEquals(Gender.MASCULINE, detector.detect("Toni"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Valdecir'")
    void detect_129() {
        assertEquals(Gender.MASCULINE, detector.detect("Valdecir"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Valdir'")
    void detect_130() {
        assertEquals(Gender.MASCULINE, detector.detect("Valdir"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Valter'")
    void detect_131() {
        assertEquals(Gender.MASCULINE, detector.detect("Valter"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Vicent'")
    void detect_132() {
        assertEquals(Gender.MASCULINE, detector.detect("Vicent"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Vicente'")
    void detect_133() {
        assertEquals(Gender.MASCULINE, detector.detect("Vicente"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Walter'")
    void detect_134() {
        assertEquals(Gender.MASCULINE, detector.detect("Walter"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Weslei'")
    void detect_135() {
        assertEquals(Gender.MASCULINE, detector.detect("Weslei"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Wilian'")
    void detect_136() {
        assertEquals(Gender.MASCULINE, detector.detect("Wilian"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Adriane'")
    void detect_137() {
        assertEquals(Gender.FEMININE, detector.detect("Adriane"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Jose'")
    void detect_138() {
        assertEquals(Gender.FEMININE, detector.detect("Jose"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Monique'")
    void detect_139() {
        assertEquals(Gender.FEMININE, detector.detect("Monique"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Abreu'")
    void detect_140() {
        assertEquals(Gender.MASCULINE, detector.detect("Abreu"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Tadeu'")
    void detect_141() {
        assertEquals(Gender.MASCULINE, detector.detect("Tadeu"));
    }

    @Test
    @DisplayName("Detect: Returns 'MASCULINE' when name is 'Deus'")
    void detect_142() {
        assertEquals(Gender.MASCULINE, detector.detect("Deus"));
    }

    @Test
    @DisplayName("Detect: Returns 'FEMININE' when name is 'Amanda'")
    void detect_143() {
        assertEquals(Gender.FEMININE, detector.detect("Amanda"));
    }
}
