public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String numeroCuenta;
    private String tipoCuenta;

    public CuentaBancaria(String titular, double saldo, String numeroCuenta, String tipoCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Monto inválido.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "Titular='" + titular + '\'' +
                ", Saldo=$" + saldo +
                ", Número de Cuenta='" + numeroCuenta + '\'' +
                ", Tipo='" + tipoCuenta + '\'' +
                '}';
    }
}
