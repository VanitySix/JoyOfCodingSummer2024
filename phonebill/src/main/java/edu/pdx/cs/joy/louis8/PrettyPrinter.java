package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.PhoneBillDumper;
import edu.pdx.cs.joy.louis8.PhoneBill;
import edu.pdx.cs.joy.louis8.PhoneCall;

import java.io.IOException;
import java.io.Writer;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class PrettyPrinter implements PhoneBillDumper<PhoneBill> {
    private final Writer writer;

    public PrettyPrinter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void dump(PhoneBill bill) throws IOException {
        writer.write("Phone Bill for Customer: " + bill.getCustomer() + "\n\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

        for (PhoneCall call : bill.getPhoneCalls()) {
            String beginTimeStr = call.getBeginTime().format(formatter);
            String endTimeStr = call.getEndTime().format(formatter);
            long durationMinutes = Duration.between(call.getBeginTime(), call.getEndTime()).toMinutes();

            writer.write(String.format("Caller: %s\nCallee: %s\nStart Time: %s\nEnd Time: %s\nDuration: %d minutes\n\n",
                    call.getCallerNumber(),
                    call.getCalleeNumber(),
                    beginTimeStr,
                    endTimeStr,
                    durationMinutes));
        }

        writer.flush();
    }
}
