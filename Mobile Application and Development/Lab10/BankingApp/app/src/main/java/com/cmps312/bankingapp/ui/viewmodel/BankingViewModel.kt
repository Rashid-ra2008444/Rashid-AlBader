package cmps312.bankingapp.viewmodel

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.cmps312.bankingapp.data.model.Account
import com.cmps312.bankingapp.data.model.Beneficiary
import com.cmps312.bankingapp.data.model.Transfer
import com.cmps312.bankingapp.data.webapi.QuBankService
import kotlinx.coroutines.launch

class BankingViewModel(appContext: Application) : AndroidViewModel(appContext) {
    private val TAG = "TransferViewModel"

    //    TODO("Not yet implemented")
    val quBankService = QuBankService()

    val accounts = mutableStateListOf<Account>()
    val beneficiaries = mutableStateListOf<Beneficiary>()

    //it will automatically recompose the UI once the data is received
    var transfers = mutableStateListOf<Transfer>()
    val cid = 10001

    init {
        TODO("Not yet implemented")
    }

    private suspend fun getTransfers() {
      quBankService.getTransfers(cid)
        viewModelScope.launch {
            transfers.addAll(quBankService.getTransfers(cid))
        }
    }

    // used for holding the details of new Transfer - used instead of Nav Component nav args
    lateinit var newTransfer: Transfer


    //Fund Transfer screen calls this method before naviagation
    fun setTransferFromDetails(fromAccount: String, amount: Double) {
        newTransfer = Transfer(fromAccount, amount)
    }

    fun setTransferBeneficiaryDetails(beneficiaryName: String, beneficiaryAccountNo: String) {
        newTransfer.beneficiaryName = beneficiaryName
        newTransfer.beneficiaryAccountNo = beneficiaryAccountNo
    }

    fun getAccounts() = viewModelScope.launch {
        quBankService.getAccounts(cid).let {
            accounts.addAll(it)
        }

    }

    suspend fun addTransfer(transfer: Transfer) {
        quBankService.addTransfers(transfer, transfer.transferId)
        viewModelScope.launch {
            val newTransfer =quBankService.addTransfers(transfer, transfer.transferId)
            newTransfer?.let {
                transfers.add(it)
            }
        }
    }


    fun getTransfer(transferId: String) = transfers.find { it.transferId == transferId }

    fun getAccount(accountNo: String): Account? = accounts.find { it.accountNo == accountNo }

    suspend fun getBeneficiaries() {
            quBankService.getBeneficiaries(cid).let {
                beneficiaries.addAll(it)
            }
    }

       fun deleteTransfer(transferId: String) {
        suspend { quBankService.deleteTransfers(cid) }
    }
}


