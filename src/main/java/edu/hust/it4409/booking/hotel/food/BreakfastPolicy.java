package edu.hust.it4409.booking.hotel.food;

import java.time.LocalTime;

import edu.hust.it4409.booking.hotel.HotelAmenity;

/**
 * A flexible interface to the rendering of breakfast policy.
 * <p>
 * For example, an implementation may specify that the breakfast is only
 * provided from 7AM to 10AM everyday. A possible rendering strategy would be
 * like this:
 * 
 * <pre>{@code
 * public String getBreakfastLine(BreakfastPolicy policy) {
 *   StringBuilder builder = new StringBuilder("Breakfast is provided ");
 *   if (policy.isProvided()) {
 *     builder.append(policy.appliedTo())
 *       .append(" from ")
 *       .append(formatter.format(policy.from())
 *       .append(" to ")
 *       .append(formatter.format(policy.to()));
 *   }
 *   if (policy.isSurcharged()) {
 *     builder.append(" (surcharged)");
 *   }
 *   return builder.toString();
 * }
 * }</pre>
 * <p>
 * In the above snippet, if {@code isProvided} returns {@code true},
 * {@code appliedTo} returns {@code everyday}, {@code from} returns {@code 7 AM}
 * and {@code to} returns {@code 10 AM}, the result will be "Breakfast is
 * provided everyday from 7AM to 10AM (surcharged)".
 * <p>
 * Users are free to choose the format. Some common usage may arises that
 * requires more parsing: "Breakfast is provided on weekdays from 7AM to 10AM
 * (surcharged) and provided on weekends from 7AM to 10AM (free of charged) but
 * is not provided in Winter".
 */
public interface BreakfastPolicy extends HotelAmenity {

    String appliedTo();

    boolean isProvided();

    boolean isSurcharged();

    LocalTime from();

    LocalTime to();

}
