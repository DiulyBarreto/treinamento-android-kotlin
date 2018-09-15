package br.com.cwi.cwiflix

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import br.com.cwi.cwiflix.fragments.ActorsFragment
import br.com.cwi.cwiflix.fragments.MoviesFragment
import br.com.cwi.cwiflix.fragments.SeriesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment(MoviesFragment())
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_movies -> {
                supportActionBar?.title = "MOVIES"
                openFragment(MoviesFragment())
            }

            R.id.item_series -> {
                supportActionBar?.title = "SERIES"
                openFragment(SeriesFragment())
            }

            R.id.item_actors -> {
                supportActionBar?.title = "ACTORS"
                openFragment(ActorsFragment())
            }
            else -> {
                return false
            }
        }

        drawerLayout.closeDrawers()
        return true
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerFrameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
