package com.iluwatar.mediator;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class PartyImplTest {

    @Test
    public void testPartyAction() {
        final PartyMember partyMember1 = mock(PartyMember.class);
        final PartyMember partyMember2 = mock(PartyMember.class);

        final PartyImpl party = new PartyImpl();
        party.addMember(partyMember1);
        party.addMember(partyMember2);

        verify(partyMember1).joinedParty(party);
        verify(partyMember2).joinedParty(party);

        party.act(partyMember1, Action.GOLD);
        verifyZeroInteractions(partyMember1);
        verify(partyMember2).partyAction(Action.GOLD);

        verifyNoMoreInteractions(partyMember1, partyMember2);

    }
}
