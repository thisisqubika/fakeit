package com.mooveit.fakeit;

import android.app.Fragment;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mooveit.fakeit.databinding.FragmentAddressBinding;
import com.mooveit.fakeit.databinding.FragmentAncientBinding;
import com.mooveit.fakeit.databinding.FragmentAppBinding;
import com.mooveit.fakeit.databinding.FragmentArtistBinding;
import com.mooveit.fakeit.databinding.FragmentBankBinding;
import com.mooveit.fakeit.databinding.FragmentBeerBinding;
import com.mooveit.fakeit.databinding.FragmentBookBinding;
import com.mooveit.fakeit.databinding.FragmentBusinessBinding;
import com.mooveit.fakeit.databinding.FragmentCardBinding;
import com.mooveit.fakeit.databinding.FragmentCatBinding;
import com.mooveit.fakeit.databinding.FragmentChuckNorrisFactsBinding;
import com.mooveit.fakeit.databinding.FragmentCodeBinding;
import com.mooveit.fakeit.databinding.FragmentCompanyBinding;
import com.mooveit.fakeit.databinding.FragmentCompassBinding;
import com.mooveit.fakeit.databinding.FragmentDateTimeBinding;
import com.mooveit.fakeit.databinding.FragmentDemographicBinding;
import com.mooveit.fakeit.databinding.FragmentEducatorBinding;
import com.mooveit.fakeit.databinding.FragmentEsportBinding;
import com.mooveit.fakeit.databinding.FragmentFileBinding;
import com.mooveit.fakeit.databinding.FragmentFoodBinding;
import com.mooveit.fakeit.databinding.FragmentFriendsBinding;
import com.mooveit.fakeit.databinding.FragmentGameOfThronesBinding;
import com.mooveit.fakeit.databinding.FragmentHackerBinding;
import com.mooveit.fakeit.databinding.FragmentHarryPotterBinding;
import com.mooveit.fakeit.databinding.FragmentHeyArnoldBinding;
import com.mooveit.fakeit.databinding.FragmentHipsterBinding;
import com.mooveit.fakeit.databinding.FragmentInternetBinding;
import com.mooveit.fakeit.databinding.FragmentJobBinding;
import com.mooveit.fakeit.databinding.FragmentLordOfTheRingsBinding;
import com.mooveit.fakeit.databinding.FragmentLoremBinding;
import com.mooveit.fakeit.databinding.FragmentMusicBinding;
import com.mooveit.fakeit.databinding.FragmentNameBinding;
import com.mooveit.fakeit.databinding.FragmentPhoneNumberBinding;
import com.mooveit.fakeit.databinding.FragmentPokemonBinding;
import com.mooveit.fakeit.databinding.FragmentRickAndMortyBinding;
import com.mooveit.fakeit.databinding.FragmentRockBandBinding;
import com.mooveit.fakeit.models.AddressData;
import com.mooveit.fakeit.models.AncientData;
import com.mooveit.fakeit.models.AppData;
import com.mooveit.fakeit.models.ArtistData;
import com.mooveit.fakeit.models.BankData;
import com.mooveit.fakeit.models.BeerData;
import com.mooveit.fakeit.models.BookData;
import com.mooveit.fakeit.models.BusinessData;
import com.mooveit.fakeit.models.CardData;
import com.mooveit.fakeit.models.CatData;
import com.mooveit.fakeit.models.ChuckNorrisFactsData;
import com.mooveit.fakeit.models.CodeData;
import com.mooveit.fakeit.models.CompanyData;
import com.mooveit.fakeit.models.CompassData;
import com.mooveit.fakeit.models.DateTimeData;
import com.mooveit.fakeit.models.DemographicData;
import com.mooveit.fakeit.models.ESportData;
import com.mooveit.fakeit.models.EducatorData;
import com.mooveit.fakeit.models.FileData;
import com.mooveit.fakeit.models.FoodData;
import com.mooveit.fakeit.models.FriendsData;
import com.mooveit.fakeit.models.GameOfThronesData;
import com.mooveit.fakeit.models.HackerData;
import com.mooveit.fakeit.models.HarryPotterData;
import com.mooveit.fakeit.models.HeyArnoldData;
import com.mooveit.fakeit.models.HipsterData;
import com.mooveit.fakeit.models.InternetData;
import com.mooveit.fakeit.models.JobData;
import com.mooveit.fakeit.models.LordOfTheRingsData;
import com.mooveit.fakeit.models.LoremData;
import com.mooveit.fakeit.models.MusicData;
import com.mooveit.fakeit.models.NameData;
import com.mooveit.fakeit.models.PhoneNumberData;
import com.mooveit.fakeit.models.PokemonData;
import com.mooveit.fakeit.models.RickAndMortyData;
import com.mooveit.fakeit.models.RockBandData;
import com.mooveit.fakeit.viewmodels.AddressViewModel;
import com.mooveit.fakeit.viewmodels.AncientViewModel;
import com.mooveit.fakeit.viewmodels.AppViewModel;
import com.mooveit.fakeit.viewmodels.ArtistViewModel;
import com.mooveit.fakeit.viewmodels.BankViewModel;
import com.mooveit.fakeit.viewmodels.BeerViewModel;
import com.mooveit.fakeit.viewmodels.BookViewModel;
import com.mooveit.fakeit.viewmodels.BusinessViewModel;
import com.mooveit.fakeit.viewmodels.CardViewModel;
import com.mooveit.fakeit.viewmodels.CatViewModel;
import com.mooveit.fakeit.viewmodels.ChuckNorrisFactsViewModel;
import com.mooveit.fakeit.viewmodels.CodeViewModel;
import com.mooveit.fakeit.viewmodels.CompanyViewModel;
import com.mooveit.fakeit.viewmodels.CompassViewModel;
import com.mooveit.fakeit.viewmodels.DateTimeViewModel;
import com.mooveit.fakeit.viewmodels.DemographicViewModel;
import com.mooveit.fakeit.viewmodels.ESportViewModel;
import com.mooveit.fakeit.viewmodels.EducatorViewModel;
import com.mooveit.fakeit.viewmodels.FileViewModel;
import com.mooveit.fakeit.viewmodels.FoodViewModel;
import com.mooveit.fakeit.viewmodels.FriendsViewModel;
import com.mooveit.fakeit.viewmodels.GameOfThronesViewModel;
import com.mooveit.fakeit.viewmodels.HackerViewModel;
import com.mooveit.fakeit.viewmodels.HarryPotterViewModel;
import com.mooveit.fakeit.viewmodels.HeyArnoldViewModel;
import com.mooveit.fakeit.viewmodels.HipsterViewModel;
import com.mooveit.fakeit.viewmodels.InternetViewModel;
import com.mooveit.fakeit.viewmodels.JobViewModel;
import com.mooveit.fakeit.viewmodels.LordOfTheRingsViewModel;
import com.mooveit.fakeit.viewmodels.LoremViewModel;
import com.mooveit.fakeit.viewmodels.MusicViewModel;
import com.mooveit.fakeit.viewmodels.NameViewModel;
import com.mooveit.fakeit.viewmodels.PhoneNumberViewModel;
import com.mooveit.fakeit.viewmodels.PokemonViewModel;
import com.mooveit.fakeit.viewmodels.RickAndMortyViewModel;
import com.mooveit.fakeit.viewmodels.RockBandViewModel;

public class DataFragment extends Fragment {

    public static final String TAG = DataFragment.class.getCanonicalName();
    private static final String LAYOUT_EXTRAS = TAG + ":Layout:Layout";

    private int mLayout;

    public static DataFragment newInstance(int layout) {
        DataFragment fragment = new DataFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(LAYOUT_EXTRAS, layout);
        fragment.setArguments(bundle);
        return fragment;
    }

    public DataFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mLayout = bundle.getInt(LAYOUT_EXTRAS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return getViewDataBinding(inflater, container).getRoot();
    }

    private ViewDataBinding getViewDataBinding(LayoutInflater inflater, ViewGroup container) {
        ViewDataBinding binding;
        switch (mLayout) {
            case R.layout.fragment_address:
                binding = FragmentAddressBinding.inflate(inflater, container, false);
                ((FragmentAddressBinding) binding).setViewModel(new AddressViewModel(new AddressData()));
                break;
            case R.layout.fragment_ancient:
                binding = FragmentAncientBinding.inflate(inflater, container, false);
                ((FragmentAncientBinding) binding).setViewModel(new AncientViewModel(new AncientData()));
                break;
            case R.layout.fragment_business:
                binding = FragmentBusinessBinding.inflate(inflater, container, false);
                ((FragmentBusinessBinding) binding).setViewModel(new BusinessViewModel(new BusinessData()));
                break;
            case R.layout.fragment_card:
                binding = FragmentCardBinding.inflate(inflater, container, false);
                ((FragmentCardBinding) binding).setViewModel(new CardViewModel(new CardData()));
                break;
            case R.layout.fragment_app:
                binding = FragmentAppBinding.inflate(inflater, container, false);
                ((FragmentAppBinding) binding).setViewModel(new AppViewModel(new AppData()));
                break;
            case R.layout.fragment_artist:
                binding = FragmentArtistBinding.inflate(inflater, container, false);
                ((FragmentArtistBinding) binding).setViewModel(new ArtistViewModel(new ArtistData()));
                break;
            case R.layout.fragment_bank:
                binding = FragmentBankBinding.inflate(inflater, container, false);
                ((FragmentBankBinding) binding).setViewModel(new BankViewModel(new BankData()));
                break;
            case R.layout.fragment_beer:
                binding = FragmentBeerBinding.inflate(inflater, container, false);
                ((FragmentBeerBinding) binding).setViewModel(new BeerViewModel(new BeerData()));
                break;
            case R.layout.fragment_book:
                binding = FragmentBookBinding.inflate(inflater, container, false);
                ((FragmentBookBinding) binding).setViewModel(new BookViewModel(new BookData()));
                break;
            case R.layout.fragment_cat:
                binding = FragmentCatBinding.inflate(inflater, container, false);
                ((FragmentCatBinding) binding).setViewModel(new CatViewModel(new CatData()));
                break;
            case R.layout.fragment_chuck_norris_facts:
                binding = FragmentChuckNorrisFactsBinding.inflate(inflater, container, false);
                ((FragmentChuckNorrisFactsBinding) binding).setViewModel(new ChuckNorrisFactsViewModel(new ChuckNorrisFactsData()));
                break;
            case R.layout.fragment_code:
                binding = FragmentCodeBinding.inflate(inflater, container, false);
                ((FragmentCodeBinding) binding).setViewModel(new CodeViewModel(new CodeData()));
                break;
            case R.layout.fragment_company:
                binding = FragmentCompanyBinding.inflate(inflater, container, false);
                ((FragmentCompanyBinding) binding).setViewModel(new CompanyViewModel(new CompanyData()));
                break;
            case R.layout.fragment_compass:
                binding = FragmentCompassBinding.inflate(inflater, container, false);
                ((FragmentCompassBinding) binding).setViewModel(new CompassViewModel(new CompassData()));
                break;
            case R.layout.fragment_demographic:
                binding = FragmentDemographicBinding.inflate(inflater, container, false);
                ((FragmentDemographicBinding) binding).setViewModel(new DemographicViewModel(new DemographicData()));
                break;
            case R.layout.fragment_date_time:
                binding = FragmentDateTimeBinding.inflate(inflater, container, false);
                ((FragmentDateTimeBinding) binding).setViewModel(new DateTimeViewModel(new DateTimeData()));
                break;
            case R.layout.fragment_educator:
                binding = FragmentEducatorBinding.inflate(inflater, container, false);
                ((FragmentEducatorBinding) binding).setViewModel(new EducatorViewModel(new EducatorData()));
                break;
            case R.layout.fragment_esport:
                binding = FragmentEsportBinding.inflate(inflater, container, false);
                ((FragmentEsportBinding) binding).setViewModel(new ESportViewModel(new ESportData()));
                break;
            case R.layout.fragment_file:
                binding = FragmentFileBinding.inflate(inflater, container, false);
                ((FragmentFileBinding) binding).setViewModel(new FileViewModel(new FileData()));
                break;
            case R.layout.fragment_food:
                binding = FragmentFoodBinding.inflate(inflater, container, false);
                ((FragmentFoodBinding) binding).setViewModel(new FoodViewModel(new FoodData()));
                break;
            case R.layout.fragment_friends:
                binding = FragmentFriendsBinding.inflate(inflater, container, false);
                ((FragmentFriendsBinding) binding).setViewModel(new FriendsViewModel(new FriendsData()));
                break;
            case R.layout.fragment_game_of_thrones:
                binding = FragmentGameOfThronesBinding.inflate(inflater, container, false);
                ((FragmentGameOfThronesBinding) binding).setViewModel(new GameOfThronesViewModel(new GameOfThronesData()));
                break;
            case R.layout.fragment_hacker:
                binding = FragmentHackerBinding.inflate(inflater, container, false);
                ((FragmentHackerBinding) binding).setViewModel(new HackerViewModel(new HackerData()));
                break;
            case R.layout.fragment_harry_potter:
                binding = FragmentHarryPotterBinding.inflate(inflater, container, false);
                ((FragmentHarryPotterBinding) binding).setViewModel(new HarryPotterViewModel(new HarryPotterData()));
                break;
            case R.layout.fragment_hey_arnold:
                binding = FragmentHeyArnoldBinding.inflate(inflater, container, false);
                ((FragmentHeyArnoldBinding) binding).setViewModel(new HeyArnoldViewModel(new HeyArnoldData()));
                break;
            case R.layout.fragment_hipster:
                binding = FragmentHipsterBinding.inflate(inflater, container, false);
                ((FragmentHipsterBinding) binding).setViewModel(new HipsterViewModel(new HipsterData()));
                break;
            case R.layout.fragment_internet:
                binding = FragmentInternetBinding.inflate(inflater, container, false);
                ((FragmentInternetBinding) binding).setViewModel(new InternetViewModel(new InternetData()));
                break;
            case R.layout.fragment_job:
                binding = FragmentJobBinding.inflate(inflater, container, false);
                ((FragmentJobBinding) binding).setViewModel(new JobViewModel(new JobData()));
                break;
            case R.layout.fragment_lord_of_the_rings:
                binding = FragmentLordOfTheRingsBinding.inflate(inflater, container, false);
                ((FragmentLordOfTheRingsBinding) binding).setViewModel(new LordOfTheRingsViewModel(new LordOfTheRingsData()));
                break;
            case R.layout.fragment_lorem:
                binding = FragmentLoremBinding.inflate(inflater, container, false);
                ((FragmentLoremBinding) binding).setViewModel(new LoremViewModel(new LoremData()));
                break;
            case R.layout.fragment_music:
                binding = FragmentMusicBinding.inflate(inflater, container, false);
                ((FragmentMusicBinding) binding).setViewModel(new MusicViewModel(new MusicData()));
                break;
            case R.layout.fragment_phone_number:
                binding = FragmentPhoneNumberBinding.inflate(inflater, container, false);
                ((FragmentPhoneNumberBinding) binding).setViewModel(new PhoneNumberViewModel(new PhoneNumberData()));
                break;
            case R.layout.fragment_pokemon:
                binding = FragmentPokemonBinding.inflate(inflater, container, false);
                ((FragmentPokemonBinding) binding).setViewModel(new PokemonViewModel(new PokemonData()));
                break;
            case R.layout.fragment_rick_and_morty:
                binding = FragmentRickAndMortyBinding.inflate(inflater, container, false);
                ((FragmentRickAndMortyBinding) binding).setViewModel(new RickAndMortyViewModel(new RickAndMortyData()));
                break;
            case R.layout.fragment_rock_band:
                binding = FragmentRockBandBinding.inflate(inflater, container, false);
                ((FragmentRockBandBinding) binding).setViewModel(new RockBandViewModel(new RockBandData()));
                break;
            default:
                binding = FragmentNameBinding.inflate(inflater, container, false);
                ((FragmentNameBinding) binding).setViewModel(new NameViewModel(new NameData()));
                break;
        }
        return binding;
    }
}