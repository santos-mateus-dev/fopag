package br.com.servirdev.fopag.domain.pagamento;

public class DescontoIRRF {
    //---------Tabela IRRF---------
    double aliquota1 = 0.075;
    double aliquota2 = 0.15;
    double aliquota3 = 0.225;
    double aliquota4 = 0.275;

    double deducao1 = 169.44;
    double deducao2 = 381.44;
    double deducao3 = 662.77;
    double deducao4 = 896.00;

    double tetoInss = 951.64;

    //Cálculo
    public double calcular(double baseCalculo) {
        double valorDescontoIRRF = 0;
        if (baseCalculo <= 1518) {
            valorDescontoIRRF = baseCalculo * aliquota1;
        } else if (baseCalculo > 1518 && baseCalculo <= 2793.88) {
            valorDescontoIRRF = (baseCalculo * aliquota2) - deducao2;
        } else if (baseCalculo > 2793.88 && baseCalculo <= 4190.83) {
            valorDescontoIRRF = (baseCalculo * aliquota3) - deducao3;
        } else if (baseCalculo > 4190.83 && baseCalculo <= 8157.41) {
            valorDescontoIRRF = (baseCalculo * aliquota4) - deducao4;
        } else {
            valorDescontoIRRF = tetoInss;
        }

        return valorDescontoIRRF;
    }
}   
