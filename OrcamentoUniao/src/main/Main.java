package main;

import dao.AcaoDAO;
import dao.CategoriaEconomicaDAO;
import dao.ElementoDespesaDAO;
import dao.FuncaoDAO;
import dao.GrupoDespesaDAO;
import dao.OrgaoSubordinadoDAO;
import dao.OrgaoSuperiorDAO;
import dao.ProgramaOrcamentarioDAO;
import dao.SubfuncaoDAO;
import dao.UnidadeOrcamentariaDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import model.Acao;
import model.CategoriaEconomica;
import model.ElementoDespesa;
import model.Funcao;
import model.GrupoDespesa;
import model.OrgaoSubordinado;
import model.OrgaoSuperior;
import model.ProgramaOrcamentario;
import model.Subfuncao;
import model.UnidadeOrcamentaria;

/**
 *
 * @author icaro
 */
public class Main {

    static String[][] DADOS = new String[24774][25];
    static ArrayList<Acao> acaoList = new ArrayList<>();
    static ArrayList<CategoriaEconomica> categoriaEconomicaList = new ArrayList<>();
    static ArrayList<ElementoDespesa> elementoDespesaList = new ArrayList<>();
    static ArrayList<Funcao> funcaoList = new ArrayList<>();
    static ArrayList<GrupoDespesa> grupoDespesaList = new ArrayList<>();
    static ArrayList<OrgaoSubordinado> orgaoSubordinadoList = new ArrayList<>();
    static ArrayList<OrgaoSuperior> orgaoSuperiorList = new ArrayList<>();
    static ArrayList<ProgramaOrcamentario> programaOrcamentarioList = new ArrayList<>();
    static ArrayList<Subfuncao> subfuncaoList = new ArrayList<>();
    static ArrayList<UnidadeOrcamentaria> unidadeOrcamentariaList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        getLinhas();
        popularDados();
        //inserirDB();

        elementoDespesaList.forEach((elementoDespesa) -> {
            elementoDespesa.toString();
        });
    }

    public static void getLinhas() throws Exception {
        String linha;
        int i = 0;

        try (
                FileInputStream inFile = new FileInputStream(new File("src\\main\\2021_OrcamentoDespesa.csv"));
                BufferedReader buff = new BufferedReader(new InputStreamReader(inFile, "Cp1252"))) {

            linha = buff.readLine();

            DADOS[i++] = linha.split(";");;

            do {
                linha = buff.readLine();
                if (linha != null) {
                    DADOS[i++] = linha.split(";");
                }
            } while (linha != null);
        }
    }

    public static boolean popularDados() throws Exception {
        int i = 0, j = 0;
        String valor;
        OrgaoSuperior orgaoSuperior;
        OrgaoSubordinado orgaoSubordinado;
        UnidadeOrcamentaria unidadeOrcamentaria;
        Funcao funcao;
        Subfuncao subfuncao;
        ProgramaOrcamentario programaOrcamentario;
        Acao acao;
        CategoriaEconomica categoriaEconomica;
        GrupoDespesa grupoDespesa;
        ElementoDespesa elementoDespesa;

        do {
            i++;

            orgaoSuperior = new OrgaoSuperior();
            orgaoSubordinado = new OrgaoSubordinado();
            unidadeOrcamentaria = new UnidadeOrcamentaria();
            funcao = new Funcao();
            subfuncao = new Subfuncao();
            programaOrcamentario = new ProgramaOrcamentario();
            acao = new Acao();
            categoriaEconomica = new CategoriaEconomica();
            grupoDespesa = new GrupoDespesa();
            elementoDespesa = new ElementoDespesa();

            // Órgão superior
            orgaoSuperior.setExercicio(Integer.parseInt(DADOS[i][j]));
            j++;
            orgaoSuperior.setIdOrgaoSuperior(Integer.parseInt(DADOS[i][j]));
            j++;
            orgaoSuperior.setNomeOrgaoSuperior(DADOS[i][j]);
            j++;
            orgaoSuperiorList.add(orgaoSuperior);

            // Órgão subordinado
            orgaoSubordinado.setIdOrgaoSubordinado(Integer.parseInt(DADOS[i][j]));
            j++;
            orgaoSubordinado.setNomeOrgaoSubordinado(DADOS[i][j]);
            j++;
            orgaoSubordinado.setIdOrgaoSuperior(orgaoSuperior);
            orgaoSubordinadoList.add(orgaoSubordinado);

            // Undidade orçamentária
            unidadeOrcamentaria.setIdUnidadeOrcamentaria(Integer.parseInt(DADOS[i][j]));
            j++;
            unidadeOrcamentaria.setNomeUnidadeOrcamentaria(DADOS[i][j]);
            j++;
            unidadeOrcamentaria.setIdOrgaoSubordinado(orgaoSubordinado);
            unidadeOrcamentariaList.add(unidadeOrcamentaria);

            // Função
            funcao.setIdFuncao(Integer.parseInt(DADOS[i][j]));
            j++;
            funcao.setNomeFuncao(DADOS[i][j]);
            j++;
            funcao.setIdUnidadeOrcamentaria(unidadeOrcamentaria);
            funcaoList.add(funcao);

            // Subfunção
            subfuncao.setIdSubfuncao(Integer.parseInt(DADOS[i][j]));
            j++;
            subfuncao.setNomeSubfuncao(DADOS[i][j]);
            j++;
            subfuncao.setIdFuncao(funcao);
            subfuncaoList.add(subfuncao);

            // Programa orçamentário
            programaOrcamentario.setIdProgramaOrcamentario(Integer.parseInt(DADOS[i][j]));
            j++;
            programaOrcamentario.setNomeProgramaOrcamentario(DADOS[i][j]);
            j++;
            programaOrcamentario.setIdSubfuncao(subfuncao);
            programaOrcamentarioList.add(programaOrcamentario);

            // Ação
            acao.setIdAcao(DADOS[i][j]);
            j++;
            acao.setNomeAcao(DADOS[i][j]);
            j++;
            acao.setIdProgramaOrcamentario(programaOrcamentario);
            acaoList.add(acao);

            // Categoria econômica
            categoriaEconomica.setIdCategoriaEconomica(Integer.parseInt(DADOS[i][j]));
            j++;
            categoriaEconomica.setNomeCategoriaEconomica(DADOS[i][j]);
            j++;
            categoriaEconomica.setIdAcao(acao);
            categoriaEconomicaList.add(categoriaEconomica);

            // Grupo despesa
            grupoDespesa.setIdGrupoDespesa(Integer.parseInt(DADOS[i][j]));
            j++;
            grupoDespesa.setNomeGrupoDespesa(DADOS[i][j]);
            j++;
            grupoDespesa.setIdCategoriaEconomica(categoriaEconomica);
            grupoDespesaList.add(grupoDespesa);

            // Elemento despesa
            elementoDespesa.setIdElementoDespesa(Integer.parseInt(DADOS[i][j]));
            j++;
            elementoDespesa.setNomeElementoDespesa(DADOS[i][j]);
            j++;
            valor = DADOS[i][j];
            valor = valor.replace(",", ".");
            elementoDespesa.setOrcamentoInicial(new BigDecimal(valor));
            j++;
            valor = DADOS[i][j];
            valor = valor.replace(",", ".");
            elementoDespesa.setOrcamentoAtualizado(new BigDecimal(valor));
            j++;
            valor = DADOS[i][j];
            valor = valor.replace(",", ".");
            elementoDespesa.setOrcamentoEmpenhado(new BigDecimal(valor));
            j++;
            valor = DADOS[i][j];
            valor = valor.replace(",", ".");
            elementoDespesa.setOrcamentoRealizado(new BigDecimal(valor));
            j++;
            elementoDespesa.setIdGrupoDespesa(grupoDespesa);
            elementoDespesaList.add(elementoDespesa);

            j = 0;
        } while (i != 24773);

        return true;
    }

    public static boolean inserirDB() throws Exception {
        OrgaoSuperiorDAO orgaoSuperiorDAO = new OrgaoSuperiorDAO();
        OrgaoSubordinadoDAO orgaoSubordinadoDAO = new OrgaoSubordinadoDAO();
        UnidadeOrcamentariaDAO unidadeOrcamentariaDAO = new UnidadeOrcamentariaDAO();
        FuncaoDAO funcaoDAO = new FuncaoDAO();
        SubfuncaoDAO subfuncaoDAO = new SubfuncaoDAO();
        ProgramaOrcamentarioDAO programaOrcamentarioDAO = new ProgramaOrcamentarioDAO();
        AcaoDAO acaoDAO = new AcaoDAO();
        CategoriaEconomicaDAO categoriaEconomicaDAO = new CategoriaEconomicaDAO();
        GrupoDespesaDAO grupoDespesaDAO = new GrupoDespesaDAO();
        ElementoDespesaDAO elementoDespesaDAO = new ElementoDespesaDAO();

        orgaoSuperiorList.forEach((orgaoSuperior) -> {
            if (orgaoSuperiorDAO.searchByPK(orgaoSuperior.getIdOrgaoSuperior()) == null) {
                orgaoSuperiorDAO.insert(orgaoSuperior);
            }
        });

        orgaoSubordinadoList.forEach((orgaoSubordinado) -> {
            if (orgaoSubordinadoDAO.searchByPK(orgaoSubordinado.getIdOrgaoSubordinado()) == null) {
                orgaoSubordinadoDAO.insert(orgaoSubordinado);
            }
        });

        unidadeOrcamentariaList.forEach((unidadeOrcamentaria) -> {
            if (unidadeOrcamentariaDAO.searchByPK(unidadeOrcamentaria.getIdUnidadeOrcamentaria()) == null) {
                unidadeOrcamentariaDAO.insert(unidadeOrcamentaria);
            }
        });

        funcaoList.forEach((funcao) -> {
            if (funcaoDAO.searchByPK(funcao.getIdFuncao()) == null) {
                funcaoDAO.insert(funcao);
            }
        });

        subfuncaoList.forEach((subfuncao) -> {
            if (subfuncaoDAO.searchByPK(subfuncao.getIdSubfuncao()) == null) {
                subfuncaoDAO.insert(subfuncao);
            }
        });

        programaOrcamentarioList.forEach((programaOrcamentario) -> {
            if (programaOrcamentarioDAO.searchByPK(programaOrcamentario.getIdProgramaOrcamentario()) == null) {
                programaOrcamentarioDAO.insert(programaOrcamentario);
            }
        });

        acaoList.forEach((acao) -> {
            if (acaoDAO.searchByPK(acao.getIdAcao()) == null) {
                acaoDAO.insert(acao);
            }
        });

        categoriaEconomicaList.forEach((categoriaEconomica) -> {
            if (categoriaEconomicaDAO.searchByPK(categoriaEconomica.getIdCategoriaEconomica()) == null) {
                categoriaEconomicaDAO.insert(categoriaEconomica);
            }
        });

        grupoDespesaList.forEach((grupoDespesa) -> {
            if (grupoDespesaDAO.searchByPK(grupoDespesa.getIdGrupoDespesa()) == null) {
                grupoDespesaDAO.insert(grupoDespesa);
            }
        });

        elementoDespesaList.forEach((elementoDespesa) -> {
            if (elementoDespesaDAO.searchByPK(elementoDespesa.getIdElementoDespesa()) == null) {
                elementoDespesaDAO.insert(elementoDespesa);
            }
        });
        return true;
    }
}
