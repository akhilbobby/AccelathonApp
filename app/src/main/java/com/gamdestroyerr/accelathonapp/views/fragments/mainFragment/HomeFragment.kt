package com.gamdestroyerr.accelathonapp.views.fragments.mainFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.gamdestroyerr.accelathonapp.R
import com.gamdestroyerr.accelathonapp.databinding.FragmentAddOptionsModalDialogBinding
import com.gamdestroyerr.accelathonapp.views.activity.MainActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var  navController: NavController
    private lateinit var  bindingDialog: FragmentAddOptionsModalDialogBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        bindingDialog = FragmentAddOptionsModalDialogBinding.inflate(layoutInflater)
        val activity = activity as MainActivity

        activity.binding.addFab.apply {
            show()
            setOnClickListener {
                val bottomSheetDialog = BottomSheetDialog(
                    requireContext(),
                    R.style.BottomSheetDialogTheme,
                )
                val bottomSheetView: View = bindingDialog.root

                with(bottomSheetDialog) {
                    setContentView(bottomSheetView)
                    show()
                }
                bottomSheetView.post {
                    bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
                bottomSheetView.apply {
                    bindingDialog.ask.setOnClickListener {
                        navController.navigate(R.id.action_homeFragment_to_makeRequestFragment)
                        bottomSheetDialog.dismiss()
                    }
                    bindingDialog.share.setOnClickListener {
                        navController.navigate(R.id.action_homeFragment_to_shareFragment)
                        bottomSheetDialog.dismiss()
                    }
                }
            }
        }
    }
}