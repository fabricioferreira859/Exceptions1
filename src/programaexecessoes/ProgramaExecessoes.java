package programaexecessoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Conta;
import model.excessoes.DomainException;


public class ProgramaExecessoes {

    public static void main(String[] args) {
       
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            List<Conta> pessoas = new ArrayList<>();

            System.out.print("Número de pessoas: ");
            int n = sc.nextInt();
            
            for(int i =1; i <= n; i++){
                System.out.println("\n\n------------ Dados da conta "+i+"------------");
                System.out.print("Data da operaçao: ");
                Date data = sdf.parse(sc.next());
                System.out.print("Número: ");
                int num = sc.nextInt();
                System.out.print("Titular: ");
                String titular = sc.next();
                System.out.print("Saldo inicial: ");
                double saldo = sc.nextDouble();
                System.out.print("Limite de saque: ");
                double limiteSaque = sc.nextDouble();

                Conta ct = new Conta(data, num, titular, saldo, limiteSaque);

                System.out.print("Deseja fazer um saque? ");
                char op = sc.next().charAt(0);

                if(op == 's'){
                     System.out.print("\nValor do saque: ");
                    double saque = sc.nextDouble();
                    ct.saque(saque);
                }
                pessoas.add(ct);
            }
            for(Conta c: pessoas){
                System.out.println("\n"+c);
            }
        }
        catch(DomainException e){
            System.out.println("\nErro de saque: "+e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("\nErro inesperado");
        }
        catch(ParseException e){
            System.out.println("Você digitou um formato de data inválida!!");
        }
    }
}
