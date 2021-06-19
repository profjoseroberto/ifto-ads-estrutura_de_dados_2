package edu.edii.binarysearchtreeavl;

public class Cliente {
    private String nome;
    private char sexo;
    private boolean isMae ;
    private boolean isPai;

    

    public Cliente(String nome, char sexo, boolean isMae, boolean isPai) {
        this.nome = nome;
        this.sexo = sexo;
        this.isMae = isMae;
        this.isPai = isPai;
    }
   
    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public char getSexo() {
        return sexo;
    }



    public void setSexo(char sexo) {
        this.sexo = sexo;
    }



    public boolean isMae() {
        return isMae;
    }



    public void setMae(boolean isMae) {
        this.isMae = isMae;
    }



    public boolean isPai() {
        return isPai;
    }



    public void setPai(boolean isPai) {
        this.isPai = isPai;
    }



    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", sexo=" + sexo + "]";
    }

    


}
