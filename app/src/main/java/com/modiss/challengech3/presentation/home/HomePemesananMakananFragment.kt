package com.modiss.challengech3.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.modiss.challengech3.GridMakananAdapter
import com.modiss.challengech3.ListMakananAdapter
import com.modiss.challengech3.Makanan
import com.modiss.challengech3.R
import com.modiss.challengech3.databinding.FragmentHomePemesananMakananBinding


class HomePemesananMakananFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentHomePemesananMakananBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<Makanan>()
    private var isGrid = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomePemesananMakananBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvListMakanan.setHasFixedSize(true)

        list.addAll(getListMakanan())
        showRecyclerList()
        binding.btnList.setOnClickListener {
            if (!isGrid) {
                binding.btnList.setImageDrawable(requireContext().getDrawable(R.drawable.ic_large_list))
                showRecyclerGrid()
            } else {
                binding.btnList.setImageDrawable(requireContext().getDrawable(R.drawable.ic_bullet_list))
                showRecyclerList()
            }
            isGrid = !isGrid

        }
    }

    private fun showRecyclerGrid() {
        binding.rvListMakanan.layoutManager = GridLayoutManager(requireContext(), 2)
        val gridMakananAdapter = GridMakananAdapter(list, onClick = {
            val toDetailFoodFragment = com.modiss.challengech3.HomePemesananMakananFragmentDirections.actionHomePemesananMakananFragmentToDetailFoodFragment(it)
            view?.findNavController()?.navigate(toDetailFoodFragment)
        })
        binding.rvListMakanan.adapter = gridMakananAdapter

    }

    private fun getListMakanan(): ArrayList<Makanan> {
        val dataNama = resources.getStringArray(R.array.nama_makanan)
        val dataHarga = resources.getStringArray(R.array.harga_makanan)
        val dataPhoto = resources.obtainTypedArray(R.array.photo_makanan)
        val listMakanan = ArrayList<Makanan>()
        for (i in dataNama.indices) {
            val makanan =
                Makanan(dataNama[i], dataHarga[i], dataPhoto.getResourceId(i, -1))
            listMakanan.add(makanan)
        }
        return listMakanan
    }

    private fun showRecyclerList() {
        binding.rvListMakanan.layoutManager = LinearLayoutManager(requireContext())
        val listMakananAdapter = ListMakananAdapter(list, onClick = {
            val toDetailFoodFragment = com.modiss.challengech3.HomePemesananMakananFragmentDirections.actionHomePemesananMakananFragmentToDetailFoodFragment(it)
            view?.findNavController()?.navigate(toDetailFoodFragment)
        })
        binding.rvListMakanan.adapter = listMakananAdapter

    }
}