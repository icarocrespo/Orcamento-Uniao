package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
        //popularDados();

        System.out.println(DADOS[1][0]);
        System.out.println(orgaoSuperiorList.get(0).getExercicio());
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

        do {
            i++;
            orgaoSuperiorList.add(new OrgaoSuperior(Integer.parseInt(DADOS[i][j]), DADOS[i][j++], Integer.parseInt(DADOS[i][j++])));

        } while (i != 24773);

        return true;
    }
}
