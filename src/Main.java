import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CuentaBancaria> cuentas = new ArrayList<>();
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("""
                ---- Menú Banco ----
                1. Crear cuenta
                2. Mostrar todas las cuentas
                3. Depositar dinero
                4. Retirar dinero
                5. Transferir dinero
                6. Salir
                """);

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del titular: ");
                    String titular = scanner.nextLine();
                    System.out.print("Ingrese saldo inicial: ");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese el número de cuenta: ");
                    String numeroCuenta = scanner.nextLine();
                    System.out.print("Ingrese el tipo de cuenta (Ahorro/Corriente): ");
                    String tipoCuenta = scanner.nextLine();

                    cuentas.add(new CuentaBancaria(titular, saldo, numeroCuenta, tipoCuenta));
                    System.out.println("Cuenta creada exitosamente.");
                }
                case 2 -> {
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas registradas.");
                    } else {
                        System.out.println("Listado de cuentas:");
                        for (CuentaBancaria cuenta : cuentas) {
                            System.out.println(cuenta);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el número de cuenta: ");
                    String numeroCuenta = scanner.nextLine();
                    CuentaBancaria cuenta = buscarCuenta(cuentas, numeroCuenta);
                    if (cuenta != null) {
                        System.out.print("Ingrese el monto a depositar: ");
                        double monto = scanner.nextDouble();
                        cuenta.depositar(monto);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese el número de cuenta: ");
                    String numeroCuenta = scanner.nextLine();
                    CuentaBancaria cuenta = buscarCuenta(cuentas, numeroCuenta);
                    if (cuenta != null) {
                        System.out.print("Ingrese el monto a retirar: ");
                        double monto = scanner.nextDouble();
                        cuenta.retirar(monto);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                }
                case 5 -> {
                    System.out.print("Ingrese el número de cuenta de origen: ");
                    String cuentaOrigen = scanner.nextLine();
                    CuentaBancaria origen = buscarCuenta(cuentas, cuentaOrigen);

                    if (origen != null) {
                        System.out.print("Ingrese el número de cuenta de destino: ");
                        String cuentaDestino = scanner.nextLine();
                        CuentaBancaria destino = buscarCuenta(cuentas, cuentaDestino);

                        if (destino != null) {
                            System.out.print("Ingrese el monto a transferir: ");
                            double monto = scanner.nextDouble();

                            if (origen.getSaldo() >= monto) {
                                origen.retirar(monto);
                                destino.depositar(monto);
                                System.out.println("Transferencia exitosa.");
                            } else {
                                System.out.println("Fondos insuficientes.");
                            }
                        } else {
                            System.out.println("Cuenta de destino no encontrada.");
                        }
                    } else {
                        System.out.println("Cuenta de origen no encontrada.");
                    }
                }
                case 6 -> {
                    System.out.println("Saliendo del sistema...");
                    ejecutando = false;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }

    public static CuentaBancaria buscarCuenta(List<CuentaBancaria> cuentas, String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}
