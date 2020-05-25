/**
 * 
 */
package com.pikablue107.programs.cardgames.base.card;

import com.pikablue107.programs.cardgames.base.card.Card.Visibility;
import com.pikablue107.programs.cardgames.base.player.Player;

/**
 * Represents a single playing card. A Card has a suit and a rank. The class
 * also handles display images for the Card.
 * 
 * @author Melody Griesen
 *
 */
public class PlayingCard extends Card {

	/** The Suit of this PlayingCard. */
	private Suit suit;
	/** The Rank of this PlayingCard. */
	private Rank rank;

	/**
	 * Creates a PlayingCard with no owner, a visibility of None, and the specified
	 * Suit and Rank.
	 * 
	 * @param visibility
	 * @param owner
	 */
	public PlayingCard(Suit suit, Rank rank) {
		this(Visibility.NONE, null, suit, rank);
	}

	/**
	 * Creates a PlayingCard with a null owner and the specified Visibility, Suit,
	 * and Rank.
	 * 
	 * @param visibility
	 * @param owner
	 */
	public PlayingCard(Visibility visibility, Suit suit, Rank rank) {
		this(visibility, null, suit, rank);
	}

	/**
	 * Creates a PlayingCard with Owner visibility, the specified Player, Suit, and
	 * Rank.
	 * 
	 * @param visibility
	 * @param owner
	 */
	public PlayingCard(Player owner, Suit suit, Rank rank) {
		this(Visibility.OWNER, owner, suit, rank);
	}

	/**
	 * Creates a PlayingCard with the specified Player, Visibility, Suit, and Rank.
	 * 
	 * @param visibility
	 * @param owner
	 */
	public PlayingCard(Visibility visibility, Player owner, Suit suit, Rank rank) {
		super(visibility, owner);
		setSuit(suit);
		setRank(rank);
	}

	/**
	 * Retrieves the suit of this PlayingCard.
	 * 
	 * @param suspect the Player attempting to view the details of this Card.
	 * @return the suit
	 */
	public Suit getSuit(Player suspect) {
		checkPermission(suspect);
		return suit;
	}

	/**
	 * @param suit the suit to set
	 */
	private void setSuit(Suit suit) {
		this.suit = suit;
	}

	/**
	 * Retrieves the rank of this PlayingCard.
	 * 
	 * @param suspect the Player attempting to view the details of this Card.
	 * @return the rank
	 */
	public Rank getRank(Player suspect) {
		checkPermission(suspect);
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	private void setRank(Rank rank) {
		this.rank = rank;
	}

	/**
	 * The rank, or number, of this PlayingCard. Ranks go from two to ten, plus
	 * Jack, Queen, King, and Ace. Each Rank has an int value that can be set. The
	 * default value for a Rank comes from its number. If it is a face card, it
	 * continues up in increments of one from 10 in the order of Jack, Queen, King,
	 * Ace, with Ace having a default int value of 14.
	 * 
	 * @author Melody Griesen
	 *
	 */
	public enum Rank {
		TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13),
		ACE(14);

		/** The int value of this Rank. */
		int value;

		/**
		 * Creates a Rank with the specified value.
		 * 
		 * @param value the value to set
		 */
		Rank(int value) {
			this.value = value;
		}

		/**
		 * Sets this Rank's value. Returns this Rank after setting it, so that it can be
		 * used immediately after constructing a Rank to set a Rank reference.
		 * 
		 * @param value the new value to set
		 * @return a reference to this Rank
		 */
		Rank setValue(int value) {
			this.value = value;
			return this;
		}
	}

	/**
	 * Common Suit of a card. Can be DIamonds Clubs, Hearts, or Spades.
	 * 
	 * @author Melody Griesen
	 *
	 */
	public enum Suit {
		DIAMONDS, CLUBS, HEARTS, SPADES
	}
}
