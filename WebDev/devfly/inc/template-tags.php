<?php
/**
 * Custom template tags for this theme
 *
 * Eventually, some of the functionality here could be replaced by core features.
 *
 * @package main_multi_theme(davfly1)
 */

if ( ! function_exists( 'main_multi_themedavfly1_posted_on' ) ) :
/**
 * Prints HTML with meta information for the current post-date/time and author.
 */
function main_multi_themedavfly1_posted_on() {
	$time_string = '<time class="entry-date published updated" datetime="%1$s">%2$s</time>';
	if ( get_the_time( 'U' ) !== get_the_modified_time( 'U' ) ) {
		$time_string = '<time class="entry-date published" datetime="%1$s">%2$s</time><time class="updated" datetime="%3$s">%4$s</time>';
	}

	$time_string = sprintf( $time_string,
		esc_attr( get_the_date( 'c' ) ),
		esc_html( get_the_date() ),
		esc_attr( get_the_modified_date( 'c' ) ),
		esc_html( get_the_modified_date() )
	);

	$posted_on = sprintf(
		esc_html_x( 'Posted on %s', 'post date', 'devfly' ),
		'<a href="' . esc_url( get_permalink() ) . '" rel="bookmark">' . $time_string . '</a>'
	);

	$byline = sprintf(
		esc_html_x( 'by %s', 'post author', 'devfly' ),
		'<span class="author vcard"><a class="url fn n" href="' . esc_url( get_author_posts_url( get_the_author_meta( 'ID' ) ) ) . '">' . esc_html( get_the_author() ) . '</a></span>'
	);

	echo '<span class="posted-on">' . $posted_on . '</span><span class="byline"> ' . $byline . '</span>'; // WPCS: XSS OK.

}
endif;

if ( ! function_exists( 'main_multi_themedavfly1_entry_footer' ) ) :
/**
 * Prints HTML with meta information for the categories, tags and comments.
 */
function main_multi_themedavfly1_entry_footer() {
	// Hide category and tag text for pages.
	if ( 'post' === get_post_type() ) {
		/* translators: used between list items, there is a space after the comma */
		$categories_list = get_the_category_list( esc_html__( ', ', 'devfly' ) );
		if ( $categories_list && main_multi_themedavfly1_categorized_blog() ) {
			printf( '<span class="cat-links">' . esc_html__( 'Posted in %1$s', 'devfly' ) . '</span>', $categories_list ); // WPCS: XSS OK.
		}

		/* translators: used between list items, there is a space after the comma */
		$tags_list = get_the_tag_list( '', esc_html__( ', ', 'devfly' ) );
		if ( $tags_list ) {
			printf( '<span class="tags-links">' . esc_html__( 'Tagged %1$s', 'devfly' ) . '</span>', $tags_list ); // WPCS: XSS OK.
		}
	}

	if ( ! is_single() && ! post_password_required() && ( comments_open() || get_comments_number() ) ) {
		echo '<span class="comments-link">';
		/* translators: %s: post title */
		comments_popup_link( sprintf( wp_kses( __( 'Leave a Comment<span class="screen-reader-text"> on %s</span>', 'devfly' ), array( 'span' => array( 'class' => array() ) ) ), get_the_title() ) );
		echo '</span>';
	}

	edit_post_link(
		sprintf(
			/* translators: %s: Name of current post */
			esc_html__( 'Edit %s', 'devfly' ),
			the_title( '<span class="screen-reader-text">"', '"</span>', false )
		),
		'<span class="edit-link">',
		'</span>'
	);
}
endif;

/**
 * Returns true if a blog has more than 1 category.
 *
 * @return bool
 */
function main_multi_themedavfly1_categorized_blog() {
	if ( false === ( $all_the_cool_cats = get_transient( 'main_multi_themedavfly1_categories' ) ) ) {
		// Create an array of all the categories that are attached to posts.
		$all_the_cool_cats = get_categories( array(
			'fields'     => 'ids',
			'hide_empty' => 1,
			// We only need to know if there is more than one category.
			'number'     => 2,
		) );

		// Count the number of categories that are attached to the posts.
		$all_the_cool_cats = count( $all_the_cool_cats );

		set_transient( 'main_multi_themedavfly1_categories', $all_the_cool_cats );
	}

	if ( $all_the_cool_cats > 1 ) {
		// This blog has more than 1 category so main_multi_themedavfly1_categorized_blog should return true.
		return true;
	} else {
		// This blog has only 1 category so main_multi_themedavfly1_categorized_blog should return false.
		return false;
	}
}

/*header slider*/
if ( ! function_exists( 'themedavfly1_get_section_header_slider' ) ) {
    /**
     * Get team members
     *
     * @return array
     */
    function themedavfly1_get_section_header_slider()
    {
        $members = get_theme_mod('themedavfly1_header_slide');
        if (is_string($members)) {
            $members = json_decode($members, true);
        }
        if (!is_array($members)) {
            $members = array();
        }
        return $members;
    }
}

/*about theme*/
if ( ! function_exists( 'themedavfly1_get_section_about_theme' ) ) {
    /**
     * Get team members
     *
     * @return array
     */
    function themedavfly1_get_section_about_theme()
    {
        $members = get_theme_mod('themedavfly1_about_partition');
        if (is_string($members)) {
            $members = json_decode($members, true);
        }
        if (!is_array($members)) {
            $members = array();
        }
        return $members;
    }
}


/*about platform theme*/
if ( ! function_exists( 'themedavfly1_get_section_about_platform' ) ) {
    /**
     * Get team members
     *
     * @return array
     */
    function themedavfly1_get_section_about_platform()
    {
        $members = get_theme_mod('themedavfly1_about_platform');
        if (is_string($members)) {
            $members = json_decode($members, true);
        }
        if (!is_array($members)) {
            $members = array();
        }
        return $members;
    }
}


/*our team theme*/
if ( ! function_exists( 'themedavfly1_get_section_our_team' ) ) {
    /**
     * Get team members
     *
     * @return array
     */
    function themedavfly1_get_section_our_team()
    {
        $members = get_theme_mod('themedavfly1_team_members');
        if (is_string($members)) {
            $members = json_decode($members, true);
        }
        if (!is_array($members)) {
            $members = array();
        }
        return $members;
    }
}

/*our team theme*/
if ( ! function_exists( 'themedavfly1_get_section_client_about_us' ) ) {
    /**
     * Get team members
     *
     * @return array
     */
    function themedavfly1_get_section_client_about_us()
    {
        $members = get_theme_mod('themedavfly1_client_about');
        if (is_string($members)) {
            $members = json_decode($members, true);
        }
        if (!is_array($members)) {
            $members = array();
        }
        return $members;
    }
}


/*Footer payment*/
if ( ! function_exists( 'themedavfly1_get_section_footer_payemnt' ) ) {
    /**
     * Get team members
     *
     * @return array
     */
    function themedavfly1_get_section_footer_payemnt()
    {
        $members = get_theme_mod('themedavfly1_footer_payment');
        if (is_string($members)) {
            $members = json_decode($members, true);
        }
        if (!is_array($members)) {
            $members = array();
        }
        return $members;
    }
}

/*our portfolio */

if ( ! function_exists( 'themedavfly1_get_section_portfolio' ) ) {
    /**
     * Get team members
     *
     * @return array
     */
    function themedavfly1_get_section_portfolio()
    {
        $members = get_theme_mod('themedavfly1_portfolio');
        if (is_string($members)) {
            $members = json_decode($members, true);
        }
        if (!is_array($members)) {
            $members = array();
        }
        return $members;
    }
}



/*Choose Ur Plan */

if ( ! function_exists( 'themedavfly1_get_section_choose_plan' ) ) {
    /**
     * Get team members
     *
     * @return array
     */
    function themedavfly1_get_section_choose_plan()
    {
        $members = get_theme_mod('themedavfly1_choose_plan');
        if (is_string($members)) {
            $members = json_decode($members, true);
        }
        if (!is_array($members)) {
            $members = array();
        }
        return $members;
    }
}
/**
 * Flush out the transients used in main_multi_themedavfly1_categorized_blog.
 */
function main_multi_themedavfly1_category_transient_flusher() {
	if ( defined( 'DOING_AUTOSAVE' ) && DOING_AUTOSAVE ) {
		return;
	}
	// Like, beat it. Dig?
	delete_transient( 'main_multi_themedavfly1_categories' );
}
add_action( 'edit_category', 'main_multi_themedavfly1_category_transient_flusher' );
add_action( 'save_post',     'main_multi_themedavfly1_category_transient_flusher' );
