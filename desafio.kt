enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        if (usuarios.isEmpty()) throw IllegalArgumentException("Matrícula inválida! Usuário vazio.") else inscritos.addAll(usuarios)        
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    // instanciando os conteúdos educacionais:
    val versionamento = ConteudoEducacional("Versionamento de código com Git e GitHub", Nivel.BASICO, 120)
    val introducaoKotlin = ConteudoEducacional("Introdução Prática à linguagem de programação Kotlin", Nivel.BASICO, 120)
    val pooKotlin = ConteudoEducacional("Programação Orientada a Objeto Java", Nivel.BASICO)
    val introducaoJava = ConteudoEducacional("Aprendendo a sintaxe Java", Nivel.BASICO, 120)
    val pooJava = ConteudoEducacional("Programação Orientada a Objeto Java", Nivel.BASICO)
    val bancoDados = ConteudoEducacional("Introdução a Banco de Dados NoSQL", Nivel.INTERMEDIARIO, 180)
    val framework = ConteudoEducacional("Contextualizando o Desenvolvimento Web com Spring Boot 3", Nivel.AVANCADO)
    
    // organizando os conteúdos para passar para suas respectivas formações
    val conteudosKotlin = listOf(versionamento, introducaoKotlin, pooKotlin, bancoDados, framework)
    val conteudosJava = listOf(versionamento, introducaoJava, pooJava, bancoDados, framework)
    
    // instanciando as formações
    val formacaoKotlin = Formacao("Kotlin Backend Developer", Nivel.INTERMEDIARIO, conteudosKotlin)
    val formacaoJava = Formacao("Formação Java Developer", Nivel.INTERMEDIARIO, conteudosJava)
 
 	// instanciando os usuários
 	val usuario1 = Usuario("Sidney")
    val usuario2 = Usuario("Ivanessa")
    val usuario3 = Usuario("Vita")
    
    // matriculando os usuários
    formacaoKotlin.matricular(usuario1, usuario2)
    formacaoJava.matricular(usuario1, usuario3)
    
    // exibindo as formações com suas informações e usuários inscritos
    println("Formação: ${formacaoKotlin.nome}\nNivel: ${formacaoKotlin.nivel}\nInscritos: ${formacaoKotlin.inscritos}\nConteúdos educacionais: ${formacaoKotlin.conteudos}")
    println()
    println("Formação: ${formacaoJava.nome}\nNivel: ${formacaoJava.nivel}\nInscritos: ${formacaoJava.inscritos}\nConteúdos educacionais: ${formacaoJava.conteudos}")
    
}