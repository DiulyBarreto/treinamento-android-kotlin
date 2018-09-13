package br.com.cwi.cwiflix

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.cwi.cwiflix.fragments.ActorsFragment
import br.com.cwi.cwiflix.fragments.MoviesFragment
import br.com.cwi.cwiflix.fragments.SeriesFragment

class MainPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> return MoviesFragment()
            1 -> return SeriesFragment()
            else -> return ActorsFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> return "Movies"
            1 -> return "Series"
            else -> return "Actors"
        }
    }

}