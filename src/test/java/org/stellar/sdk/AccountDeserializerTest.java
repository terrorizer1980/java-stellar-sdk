package org.stellar.sdk;

import com.google.gson.Gson;

import junit.framework.TestCase;

import org.junit.Test;

public class AccountDeserializerTest extends TestCase {
  @Test
  public void testDeserialize() {
    String json = "{\n" +
            "  \"id\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
            "  \"paging_token\": \"1\",\n" +
            "  \"address\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
            "  \"sequence\": 2319149195853854,\n" +
            "  \"subentry_count\": 0,\n" +
            "  \"inflation_destination\": \"GAGRSA6QNQJN2OQYCBNQGMFLO4QLZFNEHIFXOMTQVSUTWVTWT66TOFSC\",\n" +
            "  \"home_domain\": \"stellar.org\",\n" +
            "  \"thresholds\": {\n" +
            "    \"low_threshold\": 10,\n" +
            "    \"med_threshold\": 20,\n" +
            "    \"high_threshold\": 30\n" +
            "  },\n" +
            "  \"flags\": {\n" +
            "    \"auth_required\": false,\n" +
            "    \"auth_revocable\": true\n" +
            "  },\n" +
            "  \"balances\": [\n" +
            "    {\n" +
            "      \"asset_type\": \"native\",\n" +
            "      \"balance\": \"20.0000300\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"signers\": [\n" +
            "    {\n" +
            "      \"address\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
            "      \"weight\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"address\": \"GCR2KBCIU6KQXSQY5F5GZYC4WLNHCHCKW4NEGXNEZRYWLTNZIRJJY7D2\",\n" +
            "      \"weight\": 1\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    Gson gson = GsonSingleton.getInstance();
    Account account = gson.fromJson(json, Account.class);
    assertEquals(account.getKeypair().getAddress(), "GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7");
    assertEquals(account.getSequenceNumber(), new Long(2319149195853854L));
    assertEquals(account.getSubentryCount(), new Integer(0));
    assertEquals(account.getInflationDestination(), "GAGRSA6QNQJN2OQYCBNQGMFLO4QLZFNEHIFXOMTQVSUTWVTWT66TOFSC");
    assertEquals(account.getHomeDomain(), "stellar.org");

    assertEquals(account.getThresholds().getLowThreshold(), 10);
    assertEquals(account.getThresholds().getMedThreshold(), 20);
    assertEquals(account.getThresholds().getHighThreshold(), 30);

    assertEquals(account.getFlags().getAuthRequired(), false);
    assertEquals(account.getFlags().getAuthRevocable(), true);

    assertEquals(account.getBalances()[0].getAssetType(), "native");
    assertEquals(account.getBalances()[0].getBalance(), "20.0000300");

    assertEquals(account.getSigners()[0].getAddress(), "GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7");
    assertEquals(account.getSigners()[0].getWeight(), 0);
    assertEquals(account.getSigners()[1].getAddress(), "GCR2KBCIU6KQXSQY5F5GZYC4WLNHCHCKW4NEGXNEZRYWLTNZIRJJY7D2");
    assertEquals(account.getSigners()[1].getWeight(), 1);
  }
}