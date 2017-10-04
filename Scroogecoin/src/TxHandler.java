import java.util.Arrays;

public class TxHandler {

    /**
     * Creates a public ledger whose current UTXOPool (collection of unspent transaction outputs) is
     * {@code utxoPool}. This should make a copy of utxoPool by using the UTXOPool(UTXOPool uPool)
     * constructor.
     */
	
	private UTXOPool utxoPool;
	
    public TxHandler(UTXOPool utxoPool) {
	    	// IMPLEMENT THIS        
	    	this.utxoPool = new UTXOPool(utxoPool);
            
        
    }

    /**
     * @return true if:
     * (1) all outputs claimed by {@code tx} are in the current UTXO pool, 
     * (2) the signatures on each input of {@code tx} are valid, 
     * (3) no UTXO is claimed multiple times by {@code tx},
     * (4) all of {@code tx}s output values are non-negative, and
     * (5) the sum of {@code tx}s input values is greater than or equal to the sum of its output
     *     values; and false otherwise.
     */
    public boolean isValidTx(Transaction tx) {
        // IMPLEMENT THIS
    		//(1) all outputs claimed by {@code tx} are in the current UTXO pool:
    	for (Transaction.Input input:tx.getInputs()) {
    		boolean inputFound = false;
    		for(UTXO poolinput:this.utxoPool.getAllUTXO()) {
    			if (poolinput.getIndex() == input.outputIndex) {
    				inputFound = true;
    			}
    		}
    		
    			if (inputFound == false) {
    				return false;
    						
    			}
    			
    		
 
    }
    
    		return true;
    }

    /**
     * Handles each epoch by receiving an unordered array of proposed transactions, checking each
     * transaction for correctness, returning a mutually valid array of accepted transactions, and
     * updating the current UTXO pool as appropriate.
     */
    public Transaction[] handleTxs(Transaction[] possibleTxs) {
        // IMPLEMENT THIS
    	
    	Boolean[] validPool = new Boolean[possibleTxs.length];
    	int i = 0;
	for (Transaction transaction:possibleTxs) {
		boolean boolTransactionValid = isValidTx(transaction);
		validPool[i] = false;
		if (boolTransactionValid) {
			validPool[i] = true;
		}
		i++;
	}
	
/*	for(i=possibleTxs.length - 1; i>=0; i--){
       if(validPool[i] == false) {
    	   	utxoPool.;
       }
   } */
    	return possibleTxs;
    }

}
