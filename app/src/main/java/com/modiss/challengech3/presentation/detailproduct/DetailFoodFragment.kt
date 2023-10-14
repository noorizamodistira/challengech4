package com.modiss.challengech3.presentation.detailproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.modiss.challengech3.databinding.FragmentDetailFoodBinding
import android.content.Intent
import android.net.Uri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailFoodFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentDetailFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailFoodBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val makanan = com.modiss.challengech3.DetailFoodFragmentArgs.fromBundle(arguments as Bundle).makanan

        binding.tvNamaMakanan2.text = makanan.nama
        binding.tvHargaMakanan2.text = makanan.harga
        binding.ivPhotoProductDetail.setImageResource(makanan.photo)
        binding.btnAdd.setOnClickListener {
            val url = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            CoroutineScope(Dispatchers.IO).launch {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                withContext(Dispatchers.Main) {
                    startActivity(intent)
                }
            }
        }

    }
}