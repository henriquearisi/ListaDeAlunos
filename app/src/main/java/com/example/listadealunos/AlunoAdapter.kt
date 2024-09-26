import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadealunos.R

class AlunoAdapter(private val alunos: MutableList<Aluno>) : RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>() {

    inner class AlunoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNome: TextView = itemView.findViewById(R.id.tvNome)
        val tvArea: TextView = itemView.findViewById(R.id.tvArea)
        val tvData: TextView = itemView.findViewById(R.id.tvData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_aluno, parent, false)
        return AlunoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = alunos[position]
        holder.tvNome.text = aluno.nome
        holder.tvArea.text = aluno.area
        holder.tvData.text = aluno.data // Exibir a data ao lado do nome e da área
    }

    override fun getItemCount(): Int {
        return alunos.size
    }

    fun addAluno(aluno: Aluno) {
        alunos.add(aluno)
        notifyItemInserted(alunos.size - 1)
    }

    fun clearList() {
        alunos.clear()
        notifyDataSetChanged()
    }
}
