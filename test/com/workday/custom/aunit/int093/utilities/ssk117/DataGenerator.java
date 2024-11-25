package com.workday.custom.aunit.int093.utilities.ssk117;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

import com.capeclear.logger.LogControl;
import com.capeclear.logger.Logger;

public class DataGenerator {
	private Logger log = LogControl.getLogger(getClass());

	private int targetLineOutputTotal = 0;
	private String separator;
	private StringBuilder lineContent;
	
	public DataGenerator(int totalLines, String separator) {
		this.targetLineOutputTotal = totalLines;
		this.separator = separator;
		
		this.lineContent = new StringBuilder();
	}
	
	public void generateJournalLines(OutputStream stream) throws Exception {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(stream, "utf-8")));
			writeHeader(writer);
	
			Random r = new Random(System.currentTimeMillis());
			
			int writtenLines = 0;
			int writtenJournals = 0;
	
			do {
				String journalKey = "JK-" + writtenJournals;
				int nextBlockSize = r.nextInt(50000);
				int linesInJournal = (writtenLines + nextBlockSize > targetLineOutputTotal) ? 
						(targetLineOutputTotal - writtenLines) : 
							nextBlockSize;
				
				log.info("Generating journal key = " + journalKey + " with " + linesInJournal + " journal lines...");
				
				for (int x = 0; x < linesInJournal; x++) {
					writeDataLine(writer, journalKey, writtenLines);
					writtenLines++;
				}
				
				log.info("...completed journal key = " + journalKey + ". " + writtenLines + " total lines produced.");

				writtenJournals++;
			} while (writtenLines < targetLineOutputTotal);
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}
	
	private void writeHeader(PrintWriter writer) throws Exception {
		lineContent.append("JournalKey");
		lineContent.append(separator);
		lineContent.append("AccountingDate");
		lineContent.append(separator);
		lineContent.append("CompanyReferenceID");
		lineContent.append(separator);
		lineContent.append("CompanyReferenceIDType");
		lineContent.append(separator);
		lineContent.append("JournalSource");
		lineContent.append(separator);
		lineContent.append("LedgerType");
		lineContent.append(separator);
		lineContent.append("JournalEntryMemo");
		lineContent.append(separator);
		lineContent.append("LedgerAccountReferenceID_ParentIDType");
		lineContent.append(separator);
		lineContent.append("LedgerAccountReferenceID_ParentID");
		lineContent.append(separator);
		lineContent.append("LedgerAccountReferenceIDType");
		lineContent.append(separator);
		lineContent.append("LedgerAccountReferenceID");
		lineContent.append(separator);
		lineContent.append("Submit");
		lineContent.append(separator);
		lineContent.append("LockedinWorkday");
		lineContent.append(separator);
		lineContent.append("AddOnlyJournal");
		lineContent.append(separator);
		lineContent.append("BP_AutoComplete");
		lineContent.append(separator);
		lineContent.append("Round_Ledger_Amounts");
		lineContent.append(separator);
		lineContent.append("DebitAmount");
		lineContent.append(separator);
		lineContent.append("CreditAmount");
		lineContent.append(separator);
		lineContent.append("Currency");
		lineContent.append(separator);
		lineContent.append("LineCurrency");
		lineContent.append(separator);
		lineContent.append("Worktag_Cost_Center_Reference_ID");
		lineContent.append(separator);
		lineContent.append("Worktag_Location_ID");
		lineContent.append(separator);
		lineContent.append("ExternalCode_SalesDemo");

		writer.write(lineContent.toString());
		writeNewline(writer);
	}
	
	private void writeNewline(PrintWriter writer) throws Exception {
		writer.write("\r\n");
		lineContent.setLength(0);
	}
	
	private void writeDataLine(PrintWriter writer, String journalKey, int writtenLines) throws Exception {
		lineContent.append(journalKey);
		lineContent.append(separator);
		lineContent.append("2021-04-30");
		lineContent.append(separator);
		lineContent.append("GMS_USA_company");
		lineContent.append(separator);
		lineContent.append("Company_Reference_ID");
		lineContent.append(separator);
		lineContent.append("JOURNAL_SOURCE-6-106");
		lineContent.append(separator);
		lineContent.append("ACTUALS");
		lineContent.append(separator);
		lineContent.append("\"Demo to Financials Team\"");
		lineContent.append(separator);
		lineContent.append("Account_Set_ID");
		lineContent.append(separator);
		lineContent.append("ACCOUNT_SET-1");
		lineContent.append(separator);
		lineContent.append("Ledger_Account_ID");
		lineContent.append(separator);
		lineContent.append("2501");
		lineContent.append(separator);
		lineContent.append("1");
		lineContent.append(separator);
		lineContent.append("1");
		lineContent.append(separator);
		lineContent.append("1");
		lineContent.append(separator);
		lineContent.append("1");
		lineContent.append(separator);
		lineContent.append("0");
		lineContent.append(separator);
		lineContent.append("100");
		lineContent.append(separator);
		lineContent.append(separator);
		lineContent.append("USD");
		lineContent.append(separator);
		lineContent.append("USD");
		lineContent.append(separator);
		lineContent.append("12345");
		lineContent.append(separator);
		lineContent.append("Pittsburgh_site");
		lineContent.append(separator);
		lineContent.append(writtenLines);

		writer.write(lineContent.toString());
		
		writeNewline(writer);
	}
}
