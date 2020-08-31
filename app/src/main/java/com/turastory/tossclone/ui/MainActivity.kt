package com.turastory.tossclone.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.turastory.tossclone.R
import com.turastory.tossclone.databinding.LayoutAllBinding
import com.turastory.tossclone.databinding.LayoutAllItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: LayoutAllBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutAllBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHelpCenter.setOnClickListener {
            toast("Clicked ${getString(R.string.main_all_help_center)}")
        }

        binding.btnSettings.setOnClickListener {
            toast("Clicked ${getString(R.string.main_all_settings)}")
        }

        binding.layoutItemHeaderLookup.root.text = getString(R.string.main_all_lookup)
        binding.layoutItemLookupMyCards.tvText.text = getString(R.string.main_all_my_cards)

        binding.layoutItemLookupMyAccounts.initialize(
            R.drawable.ic_baseline_account_balance_wallet_24,
            R.string.main_all_my_accounts
        )

        binding.layoutItemLookupMyCards.initialize(
            R.drawable.ic_baseline_credit_card_24,
            R.string.main_all_my_cards
        )

        binding.layoutItemRemittanceSend.initialize(
            R.drawable.ic_baseline_compare_arrows_24,
            R.string.main_all_send
        )

        binding.layoutItemRemittanceDutchPay.initialize(
            R.drawable.ic_baseline_attach_money_24,
            R.string.main_all_dutch_pay
        )

        binding.layoutItemRemittanceAutoDebit.initialize(
            R.drawable.ic_baseline_calendar_today_24,
            R.string.main_all_auto_debit
        )
    }

    private fun LayoutAllItemBinding.initialize(
        @DrawableRes drawableRes: Int,
        @StringRes stringRes: Int
    ) {
        viewIcon.background = getDrawableCompat(drawableRes)
        tvText.text = getString(stringRes)
    }

    private fun Context.getDrawableCompat(@DrawableRes resId: Int): Drawable? =
        ContextCompat.getDrawable(this, resId)
            ?: throw IllegalArgumentException("Cannot find drawable with $resId.")

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}