package com.example.listadealunos

import Aluno
import AlunoAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var alunoAdapter: AlunoAdapter
    private val alunos = mutableListOf<Aluno>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNome: EditText = findViewById(R.id.etNome)
        val etArea: AutoCompleteTextView = findViewById(R.id.etArea)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val tvDataAtual: TextView = findViewById(R.id.tvDataAtual)
        val tvQuantidade: TextView = findViewById(R.id.tvQuantidade)
        val btnAdicionar: Button = findViewById(R.id.btnAdicionar)
        val btnZerar: Button = findViewById(R.id.btnZerar)

        // Configurar RecyclerView
        alunoAdapter = AlunoAdapter(alunos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = alunoAdapter

        // Exibir data atual
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        tvDataAtual.text = "Data atual: $currentDate"

        // Adicionar aluno
        btnAdicionar.setOnClickListener {
            val nome = etNome.text.toString()
            val area = etArea.text.toString()
            val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date()) // Data atual
            if (nome.isNotEmpty() && area.isNotEmpty()) {
                val aluno = Aluno(nome, area, currentDate)
                alunoAdapter.addAluno(aluno)
                tvQuantidade.text = "Quantidade de alunos: ${alunos.size}"
                etNome.text.clear()
                etArea.text.clear()
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Zerar lista
        btnZerar.setOnClickListener {
            alunoAdapter.clearList()
            tvQuantidade.text = "Quantidade de alunos: 0"
        }
    }
}
