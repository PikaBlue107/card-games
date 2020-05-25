/**
 * 
 */
package com.pikablue107.programs.cardgames.base.card;

import com.pikablue107.programs.cardgames.base.player.Player;

/**
 * Represents a single playable card. A Card
 * 
 * @author Melody Griesen
 *
 */
public abstract class Card {

	/** Who can see the properties of this Card. */
	private Visibility visibility;

	/**
	 * The player who owns this card. If null, then this Card is not owned by any
	 * player.
	 */
	Player owner;

	/**
	 * Creates a Card with no owner and a visibility of None.
	 * 
	 * @param visibility
	 * @param owner
	 */
	public Card() {
		this(Visibility.NONE, null);
	}

	/**
	 * Creates a Card with the specified Visibility and a null owner.
	 * 
	 * @param visibility
	 * @param owner
	 */
	public Card(Visibility visibility) {
		this(visibility, null);
	}

	/**
	 * Creates a Card with the specified Player and Owner visibility.
	 * 
	 * @param visibility
	 * @param owner
	 */
	public Card(Player owner) {
		this(Visibility.OWNER, owner);
	}

	/**
	 * Creates a Card with the specified Player and Visibility.
	 * 
	 * @param visibility
	 * @param owner
	 */
	public Card(Visibility visibility, Player owner) {
		setVisibility(visibility);
		setOwner(owner);
	}

	/**
	 * Determines if the provided Player has access to this Card's details.
	 * 
	 * @param suspect the suspect Player to judge access for
	 * @return true if the suspect player can see the details of this Card
	 */
	public boolean isVisibleFrom(Player suspect) {
		if (suspect == null) {
			throw new NullPointerException();
		}
		switch (visibility) {
		case PUBLIC:
			return true;
		case OWNER:
			return suspect.equals(owner);
		case OTHERS:
			return !suspect.equals(owner);
		case NONE:
			return false;
		default:
			throw new IllegalStateException("Visibility is not one of the four expected Visibilities.");
		}
	}

	/**
	 * Verifies that the player trying to retrieve this information has permission.
	 * 
	 * @param suspect the Player attempting to view the details of this Card.
	 * @throws IllegalArgumentException if the suspect player does not have
	 *                                  permission to view this
	 */
	public void checkPermission(Player suspect) {
		if (!this.isVisibleFrom(suspect))
			throw new IllegalArgumentException("That player does not have access to this Card!");
	}

	/**
	 * @return the visibility
	 */
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	/**
	 * Declares levels of visibility indicating who can see the properties of this
	 * Card. A Card can have a visibility of Public, Owner only, Non-Owner only, and
	 * None.
	 * 
	 * @author Melody Griesen
	 *
	 */
	public enum Visibility {
		/** All Players can see this Card. */
		PUBLIC,
		/** Only the Owner can see this Card. */
		OWNER,
		/** Only Players other than the Owner can see this Card. */
		OTHERS,
		/** Nobody can see this Card. */
		NONE
	}

}
