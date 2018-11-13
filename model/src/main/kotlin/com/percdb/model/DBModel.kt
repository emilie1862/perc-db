package com.percdb.model

import java.time.chrono.Era
import java.util.*

open class Person(val name: String)

class Composer(name: String, val birthDate: Date?,
               val nationality: String?,
               val era: Era,
               val deathDate: Date?, val compositions: List<Composition>) : Person(name)

class Arranger(name: String, val birthDate: Date?,
               val deathDate: Date?, val arrangements: List<Composition>) : Person(name)

class Performer(name: String, val ensembles: List<EnsembleMembership>?) : Person(name)

class EnsembleMembership(val ensemble: Ensemble, val startDate: Date?, val endDate: Date?)

data class Composition(val title: String, val composer: Composer, val arranger: Arranger?,
                       val personnel : List<Personnel>,
                       val genres: List<String>?, val ensembleType: String?, val length: String?,
                       val publisher: Publisher?, val publishDate: Date?,
                       val grade: String?,
                       val languages: List<String>?,
                       val featured: List<Instrument>,
                       val substitutions : List<InstrumentSubstitutions>?)

data class Publisher(val name: String, val landingPage: String?)

data class Performance(val date: Date, val compositions: List<Composition>,
                       val performers: List<Performer>?, val ensemble: Ensemble?,
                       val assignments: List<PartAssignment>?,
                       val location: GeoJson?)


data class Ensemble(val name: String, val ensembleType: String,
                    val performers: List<Performer>, val startDate: Date?, val endDate: Date?)

data class Instrument(val name: String, val altNames: List<String>, val description: String)

data class PartAssignment(val performer: Performer, val composition: Composition, val instruments : List<Instrument>)

data class Personnel(val frequency: String, val instrumentAssignments : List<InstrumentAssignment>)

data class InstrumentAssignment(val instruments: List<Instrument>, val numPeople: Int)

data class InstrumentSubstitutions(val frequency: String, val substitutions: Map<Instrument, Instrument>)