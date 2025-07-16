package br.com.servirdev.fopag.domain.pagamento;

public class DescontoINSS {

    //---------Tabela INSS---------
    double aliquota1 = 0.075;
    double aliquota2 = 0.09;
    double aliquota3 = 0.12;
    double aliquota4 = 0.14;

    double deducao2 = 22.77;
    double deducao3 = 106.59;
    double deducao4 = 190.40;

    double tetoInss = 951.64;

    //Cálculo
    public double calcular(double salario) {
        double valorDescontoInss = 0;
        if (salario <= 1518) {
            valorDescontoInss = salario * aliquota1;
        } else if (salario > 1518 && salario <= 2793.88) {
            valorDescontoInss = (salario * aliquota2) - deducao2;
        } else if (salario > 2793.88 && salario <= 4190.83) {
            valorDescontoInss = (salario * aliquota3) - deducao3;
        } else if (salario > 4190.83 && salario <= 8157.41) {
            valorDescontoInss = (salario * aliquota4) - deducao4;
        } else {
            valorDescontoInss = tetoInss;
        }

        return valorDescontoInss;
    }
}
